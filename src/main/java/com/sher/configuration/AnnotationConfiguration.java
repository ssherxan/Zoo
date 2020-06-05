package com.sher.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.sher")
@PropertySource("classpath:application.yml")
@EnableAspectJAutoProxy
public class AnnotationConfiguration {
}
