package ru.aston.course.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("ru.aston.course")
@EnableTransactionManagement
public class AppConfig {
}
