package com.example.demo.config;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenApiCustomiser customOpenApi() {
    return openApi -> {
      openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
        operation.getResponses()
            .addApiResponse("401", new ApiResponse()
                .description("인증 정보가 없습니다."))
            .addApiResponse("403", new ApiResponse()
                .description("권한이 없습니다."))
            .addApiResponse("500", new ApiResponse()
                .description("서버 오류"));
      }));
    };
  }

  @Bean
  public OpenAPI springShopOpenAPI() {
    return new OpenAPI()
        .info(new Info().title("Spring Swagger API")
            .description("테스트 프로젝트입니다.")
            .version("v0.0.1")
            .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/")))
        .externalDocs(new ExternalDocumentation()
            .description("OpenAPI 3 Libraury for spring-boot Documentation")
            .url("https://springdoc.org/"));
  }

}
