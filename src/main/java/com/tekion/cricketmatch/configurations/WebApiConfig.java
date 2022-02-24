package com.tekion.cricketmatch.configurations;


import com.tekion.cricketmatch.api.MatchController;
import com.tekion.cricketmatch.api.PlayerController;
import com.tekion.cricketmatch.api.TeamController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebMvc
@ComponentScan(basePackageClasses = {PlayerController.class, TeamController.class, MatchController.class})
public class WebApiConfig implements WebMvcConfigurer {

}