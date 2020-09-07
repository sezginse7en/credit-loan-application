package com.kocfinansman.creditloan.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kocfinansman.creditloan.service","com.kocfinansman.creditloan.rest",
        "com.kocfinansman.creditloan.data"})
public class CreditLoanSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditLoanSystemApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:3000");
        configuration.addAllowedHeader("content-type");
        configuration.addAllowedHeader("accept");
        configuration.setAllowCredentials(true);
        configuration.addAllowedMethod(HttpMethod.GET);
        configuration.addAllowedMethod(HttpMethod.POST);
        configuration.addAllowedMethod(HttpMethod.OPTIONS);
        source.registerCorsConfiguration("/**",configuration);
        return new CorsFilter(source);
    }

}
