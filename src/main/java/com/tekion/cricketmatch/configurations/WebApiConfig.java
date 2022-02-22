package com.tekion.cricketmatch.configurations;

import com.tekion.cricketmatch.api.PlayerController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author shivambhavsar created on: 22/02/22
 */
@EnableWebMvc
@ComponentScan(basePackageClasses = {PlayerController.class})
public class WebApiConfig implements WebMvcConfigurer {

}
