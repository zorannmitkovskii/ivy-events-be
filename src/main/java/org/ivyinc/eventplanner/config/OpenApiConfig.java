package org.ivyinc.eventplanner.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Ivy Events API",
                description = "OpenAPI specification for Ivy & Inc Events backend.",
                version = "v1",
                contact = @Contact(name = "Ivy & Inc", email = "support@ivyinc.org")
        ),
        servers = {
                @Server(url = "http://localhost:8081", description = "Local"),
                @Server(url = "http://localhost:8080", description = "Keycloak Default Port (if proxied)")
        }
)
@SecurityScheme(
        name = "bearer-jwt",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi v1GroupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("v1")
                .pathsToMatch("/v1/api/**")
                .build();
    }

    @Bean
    @Profile("!test")
    public OpenAPI ivyEventsOpenAPI() {
        // Register global bearer auth requirement so secured endpoints display the Authorize button
        io.swagger.v3.oas.models.security.SecurityScheme bearerScheme = new io.swagger.v3.oas.models.security.SecurityScheme()
                .type(io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        return new OpenAPI()
                .components(new Components().addSecuritySchemes("bearer-jwt", bearerScheme))
                .addSecurityItem(new SecurityRequirement().addList("bearer-jwt"))
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Ivy Events API")
                        .version("v1")
                        .description("REST API documentation for Ivy & Inc Events application.")
                        .license(new License().name("Proprietary"))
                );
    }
}
