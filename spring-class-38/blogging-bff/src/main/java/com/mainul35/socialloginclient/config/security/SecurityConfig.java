package com.mainul35.socialloginclient.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

    @Autowired
    private AuthSuccessHandler authSuccessHandler;

    private RedirectStrategy authorizationRedirectStrategy = new DefaultRedirectStrategy();

    @Bean
    SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry
                            .requestMatchers(
                                    "/",
                                    "/auth/**",
                                    "/login-processing",
                                    "/lib/bootstrap/**",
                                    "/css/**",
                                    "/js/**",
                                    "/images/**"

                            ).permitAll()
                            .anyRequest().authenticated();
                })
                .oauth2Login(oAuth2LoginConfigurer -> {
                    oAuth2LoginConfigurer
                            .loginPage("/login")
                            .authorizationEndpoint(authorizationEndpointConfig -> {
                                authorizationEndpointConfig.authorizationRedirectStrategy((request, response, url) -> {
                                    if (log.isDebugEnabled()) {
                                        log.debug(url);
                                    }
                                    // Overriding the behavior of spring-security-oauth2-client-6.x.x.jar
                                    // > org.springframework.security.oauth2.client.web
                                    // OAuth2AuthorizationRequestRedirectFilter#sendRedirectForAuthorization(...)
                                    authorizationRedirectStrategy.sendRedirect(request, response, url);

                                });
                            })
                            .successHandler(authSuccessHandler);
                })
                .formLogin(form -> {
                    form.loginPage("/auth/login")
                            .loginProcessingUrl("/login-processing")
                            .usernameParameter("username")
                            .passwordParameter("password")
                            .successHandler(authSuccessHandler)
                            .failureUrl("/auth/login");
                })
//                .oauth2Login(httpSecurityOAuth2LoginConfigurer -> {
//                    httpSecurityOAuth2LoginConfigurer.successHandler(authSuccessHandler);
//                })
                .logout(logout -> {
                    logout
                            .logoutUrl("/auth/logout")
                            .logoutSuccessUrl("/auth/login");
                })
                .build();
    }
}
