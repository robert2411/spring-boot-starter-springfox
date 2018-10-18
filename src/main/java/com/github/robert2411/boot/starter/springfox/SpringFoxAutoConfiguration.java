package com.github.robert2411.boot.starter.springfox;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableConfigurationProperties(SpringFoxProperties.class)
@EnableSwagger2
@Configuration
public class SpringFoxAutoConfiguration {

    private final SpringFoxProperties properties;

    public SpringFoxAutoConfiguration(SpringFoxProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                properties.getInfo().getTitle(),
                properties.getInfo().getDescription(),
                properties.getInfo().getVersion(),
                properties.getInfo().getTermsOfServiceUrl(),
                new Contact(properties.getInfo().getContact().getName(), properties.getInfo().getContact().getUrl(), properties.getInfo().getContact().getEmail()),
                properties.getInfo().getLicense().getName(),
                properties.getInfo().getLicense().getUrl(),
                Collections.<VendorExtension>emptyList());
    }
}