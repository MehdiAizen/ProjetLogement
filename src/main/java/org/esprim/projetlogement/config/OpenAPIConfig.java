package org.esprim.projetlogement.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI foyerManagementOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Foyer Management API")
                        .description("API REST complète pour la gestion des foyers universitaires")
                        .version("v1.0.0")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("Support")
                                .email("support@esprim.com")));
    }
}