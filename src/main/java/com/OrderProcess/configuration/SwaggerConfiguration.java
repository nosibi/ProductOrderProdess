package com.OrderProcess.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public GroupedOpenApi api(){
        return GroupedOpenApi.builder()
                .group("com.OrderProcess")
                .packagesToScan("com.OrderProcess")
                .build();
    }
}
