package com.rakib.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.rakib.service","com.rakib.dao"})
public class RootConfig {
}
