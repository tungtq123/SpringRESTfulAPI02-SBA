package com.tqt.sba301_se1943_springrestapi02.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Value("/v3/api-docs")
    private String apiDocPath;
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Food Management API")
                        .version("1.0")
                        .contact(new Contact()
                                .email("support@fu.org.vn")
                                .url("http://localhost:8080/")
                                .name("FU"))
                        .description("API for managing account items and categories"))
                .addServersItem(new Server().url("http://localhost:8080" + apiDocPath));
    }
}