package com.project.config;

import com.project.main.DbTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class DbContext {
    @Bean
    public DbTest db(){
        return new DbTest();
    }
}
