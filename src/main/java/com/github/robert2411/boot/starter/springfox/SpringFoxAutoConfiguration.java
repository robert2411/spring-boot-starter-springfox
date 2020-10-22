package com.github.robert2411.boot.starter.springfox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.function.Predicate;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@EnableConfigurationProperties(SpringFoxProperties.class)
@Configuration
public class SpringFoxAutoConfiguration {
    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private final SpringFoxProperties properties;

    public SpringFoxAutoConfiguration(SpringFoxProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    public Docket api() {
        DocumentationType documentationType;
        switch (properties.getConfig().getDocumentationType().toLowerCase()) {

            case "openapi":
                documentationType = DocumentationType.OAS_30;
                break;
            default:
                log.warn("Falling back on the default documentation type 'openApi' as no valid documentation type was configured. Valid options [swagger, openApi]");
            case "swagger":
                documentationType = DocumentationType.OAS_30;
                break;
        }
        return new Docket(documentationType)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(getPathSelector())
                .build()
                .apiInfo(apiInfo());
    }

    private Predicate<String> getPathSelector(){
        if(StringUtils.isEmpty(properties.getConfig().getPaths())){
            return PathSelectors.any();
        }
        return regex(properties.getConfig().getPaths());
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
                Collections.emptyList());
    }
}