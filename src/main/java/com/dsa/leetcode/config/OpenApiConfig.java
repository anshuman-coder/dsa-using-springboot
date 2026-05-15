package com.dsa.leetcode.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("LeetCode DSA API")
                        .description("Spring Boot REST API for solving LeetCode problems — each endpoint accepts POST with test inputs.")
                        .version("1.0.0"));
    }
}
