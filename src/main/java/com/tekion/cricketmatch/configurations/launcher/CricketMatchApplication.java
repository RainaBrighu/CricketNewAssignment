package com.tekion.cricketmatch.configurations.launcher;

import com.tekion.cricketmatch.configurations.WebApiConfig;
import com.tekion.cricketmatch.services.repo.IScoreCardRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan(
    basePackages = {"com.tekion"},
    excludeFilters = {
      @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.tekion\\..*launcher\\..*")
    })
@EnableAutoConfiguration(
    exclude = {
      WebMvcAutoConfiguration.class,
      ErrorMvcAutoConfiguration.class,
      DispatcherServletAutoConfiguration.class
    })
@EntityScan(basePackages = {"com.tekion.cricketmatch.services.beans"})
@EnableJpaRepositories(basePackageClasses = {IScoreCardRepo.class})
@SpringBootApplication
public class CricketMatchApplication {

  public static void main(String[] args) {
    SpringApplication.run(CricketMatchApplication.class, args);
  }

  @Bean
  public DispatcherServletRegistrationBean cricketMatchApi() {
    DispatcherServlet dispatcherServlet = new DispatcherServlet();
    AnnotationConfigWebApplicationContext applicationContext =
        new AnnotationConfigWebApplicationContext();
    applicationContext.register(WebApiConfig.class);
    dispatcherServlet.setApplicationContext(applicationContext);
    DispatcherServletRegistrationBean servletRegistrationBean =
        new DispatcherServletRegistrationBean(dispatcherServlet, "/*");
    servletRegistrationBean.setName("CricketMatchApiConfig");
    servletRegistrationBean.setLoadOnStartup(1);
    return servletRegistrationBean;
  }
}
