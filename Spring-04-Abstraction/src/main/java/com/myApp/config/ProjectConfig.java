package com.myApp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.myApp")

@ComponentScan(basePackages = {"com.myApp.proxy","com.myApp.service","com.myApp.repository"})
public class ProjectConfig {

}
