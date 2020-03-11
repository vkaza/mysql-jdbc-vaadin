package com.springboot;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.springboot")
@EntityScan("com.springboot.model")
@EnableJpaRepositories("com.springboot.repository")
public class InterviewDemo {

	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(InterviewDemo.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "9000"));
        app.run(args);
    }
}
