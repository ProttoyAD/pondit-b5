package com.mainul35.articleservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Mainul35
 */
@EnableWebSecurity
@Configuration(proxyBeanMethods = false)
public class ArticleServiceSecurityConfiguration {

	// @formatter:off
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.securityMatcher("/articles/**");
		http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
			authorizationManagerRequestMatcherRegistry
					.requestMatchers("/articles/**").hasAuthority("SCOPE_message.read");

				})
				.oauth2ResourceServer(httpSecurityOAuth2ResourceServerConfigurer -> {
					httpSecurityOAuth2ResourceServerConfigurer.jwt(Customizer.withDefaults());
				});
		return http.build();
	}
	// @formatter:on

}
