package com.fse.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Project Manager Spring Boot
 *
 */
@ComponentScan({ "com.fse.*" })
@EnableAutoConfiguration
@Configuration
@SpringBootApplication(
        exclude = { ErrorMvcAutoConfiguration.class })
public class Application
{
    public static void main(final String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}
