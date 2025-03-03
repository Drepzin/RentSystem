package com.carRentApi.carRentApi.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Rent car system",
                version = "V1",
                contact = @Contact(
                        name = "Drepz",
                        email = "drepzodev@gmail.com",
                        url = "rentCarSystem.com"
                )
        )
)
public class OpenApiConfiguration {
}
