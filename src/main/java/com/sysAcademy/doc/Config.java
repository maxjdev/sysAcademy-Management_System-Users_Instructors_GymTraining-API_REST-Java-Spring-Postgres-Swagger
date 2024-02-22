package com.sysAcademy.doc;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author maxdev
 */
@Configuration
public class Config {
    // OpenAPI (Swagger) Doc Configuration
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("sysAcademy")
                        .description("USER, INSTRUCTOR AND ACADEMIC TRAINING MANAGEMENT SYSTEM: API REST using Java, Spring-Boot, Spring-Web, Spring-Data JPA, Spring-DevTools, Postgres, Docker, DBeaver, Validation, Postman, Swagger and Lombok")
                        .version("v1.0")
                        .contact(new Contact().name("maxjdev").email("maxjramosdev@gmail.com").url("https://www.linkedin.com/in/maxjdev/"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
    }
}