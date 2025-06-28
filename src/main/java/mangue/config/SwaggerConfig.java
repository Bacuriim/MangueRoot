package mangue.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API do Mangue Chat")
                        .description("Documentação da API para o sistema de chat com usuários, amigos e mensagens")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Conrado Einstein")
                                .email("einstein@example.com")
                                .url("https://github.com/conradoeinstein"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT"))
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Repositório do Projeto")
                        .url("https://github.com/seuprojeto/mangue-chat"));
    }
}
