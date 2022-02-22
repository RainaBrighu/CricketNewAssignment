package com.tekion.cricketmatch.configurations.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class CricketMatchApplication {

  public static void main(String[] args) {
    SpringApplication.run(CricketMatchApplication.class, args);
  }

  // ServletRegistrationBean, DispatcherServlet
  @Bean
  public ServletRegistrationBean<DispatcherServlet> cricketMatchApi() {

  }
}
