package com.neusoft.core.config;

import com.neusoft.core.property.ScCloudProperties;
import com.neusoft.core.property.SwaggerProperties;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>Swagger configuration.</p>
 * <p>创建日期：2018-05-14</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    @Autowired
    private ScCloudProperties scCloudProperties;

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public Docket createRestApi() {

        SwaggerProperties swaggerProperties = scCloudProperties.getSwagger();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .enable(swaggerProperties.getEnabled());
    }

    private ApiInfo apiInfo() {
        SwaggerProperties swaggerProperties = scCloudProperties.getSwagger();
        return new ApiInfoBuilder()
                .title(applicationName)
                .description(swaggerProperties.getDescription())
                .version(swaggerProperties.getVersion())
                .build();
    }

}