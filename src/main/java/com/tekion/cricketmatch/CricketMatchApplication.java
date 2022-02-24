package com.tekion.cricketmatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.DispatcherServlet;
/*
@Configuration
@ComponentScan(
    basePackages = {"com.tekion"},
    excludeFilters = {
      @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.tekion\\..*launcher\\..*")
    })
*/

@SpringBootApplication
public class CricketMatchApplication {

  public static void main(String[] args) {
    SpringApplication.run(CricketMatchApplication.class, args);
  }
}

	/*
  // ServletRegistrationBean, DispatcherServlet
  @Bean
  public ServletRegistrationBean<DispatcherServlet> cricketMatchApi() {
    // TODO document why this method is empty

  }
}

	 */
