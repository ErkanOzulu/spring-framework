package com.myComp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.myApp")

@ComponentScan(basePackages = {"com.myComp.proxy","com.myComp.service","com.myComp.repository"})
public class ProjectConfig {

}
