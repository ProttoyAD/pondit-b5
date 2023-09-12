package com.mainul35.articleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;

@SpringBootApplication
public class ArticleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticleServiceApplication.class, args);
	}

//	@Bean
//	public JwtDecoder jwtDecoder() {
//		JwtDecoder jwtDecoder = JwtDecoders.fromIssuerLocation("");
//		return jwtDecoder;
//	}
}
