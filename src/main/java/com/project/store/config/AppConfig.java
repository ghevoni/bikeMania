package com.project.store.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.project.store")
@EntityScan("com.project.store.entities")
@EnableJpaRepositories("com.project.store.repositories")
public class AppConfig {

}
