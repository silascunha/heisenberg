package br.dev.silascunha.heisenberg.config;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		WebMvcConfigurer.super.addCorsMappings(registry);
		
		registry.addMapping("/**").allowedOrigins("*");
	}

	@Bean
	public OperationCustomizer customGlobalHeaders() {

		return (Operation operation, HandlerMethod handlerMethod) -> {

			Parameter authorizationHeader = new Parameter()
					.in(ParameterIn.HEADER.toString())
					.schema(new StringSchema())
					.name("Authorization")
					.description("Cabeçalho com o token JWT de autenticação (olhar o '/auth/login')")
					.required(false);


			operation.addParametersItem(authorizationHeader);

			return operation;
		};
	}
}
