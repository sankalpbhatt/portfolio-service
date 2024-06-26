/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI baseOpenAPI() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Portfolio Service OpenAPI Docs")
                .version("0.0.1-SNAPSHOT")
                .description("Portfolio Service"));
  }
}
