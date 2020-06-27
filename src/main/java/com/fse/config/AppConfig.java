package com.fse.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Application configuration file.
 * 
 *
 */
@Configuration
@ComponentScan(
        basePackages = { "com.fse.*" })
//@PropertySource("classpath:application.properties")
public class AppConfig
{
	
}
