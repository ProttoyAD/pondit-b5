package com.mainul35.authorizationserver.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

    @Autowired
    private AuthSuccessHandler authSuccessHandler;

    private RedirectStrategy authorizationRedirectStrategy = new DefaultRedirectStrategy();

    @Bean
    SecurityFilterChain securityFilterChain (HttpSecurity http, ClientRegistrationRepository clientRegistrationRepository) throws Exception {
        return http
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry
                            .requestMatchers(
                                    "/login",
                                    "/login-processing",
                                    "/lib/bootstrap/**",
                                    "/css/**",
                                    "/js/**",
                                    "/images/**",
                                    "/templates/**"

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
                    form.loginPage("/login")
                            .loginProcessingUrl("/login-processing")
                            .usernameParameter("username")
                            .passwordParameter("password")
                            .successHandler(authSuccessHandler)
                            .failureUrl("/login");
                })
//                .oauth2Login(httpSecurityOAuth2LoginConfigurer -> {
//                    httpSecurityOAuth2LoginConfigurer.successHandler(authSuccessHandler);
//                })
                .logout(logout ->
                    logout.logoutSuccessHandler(oidcLogoutSuccessHandler(clientRegistrationRepository))
                )
                .build();
    }

    private LogoutSuccessHandler oidcLogoutSuccessHandler(
            ClientRegistrationRepository clientRegistrationRepository) {
        OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler =
                new OidcClientInitiatedLogoutSuccessHandler(clientRegistrationRepository);

        // Set the location that the End-User's User Agent will be redirected to
        // after the logout has been performed at the Provider
        oidcLogoutSuccessHandler.setPostLogoutRedirectUri("{baseUrl}/logout");

        return oidcLogoutSuccessHandler;
    }
}
