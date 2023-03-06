package io.studerd.api.security.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class swaggerConfiguration {
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2 )
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("Gestion des cours API docimentation")
                                .title("Gestion des Cours REST API")
                                .build()

                )
                .groupName("REST API V1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.studerd.api.security"))
                .paths(PathSelectors.ant("/api/**"))
                .build();

    }
}
