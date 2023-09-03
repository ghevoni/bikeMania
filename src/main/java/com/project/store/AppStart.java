package com.project.store;

import com.project.store.config.AppConfig;
import org.springframework.boot.SpringApplication;


public class AppStart
{
    public static void main( String[] args )
    {
        SpringApplication.run(AppConfig.class);
    }
}
