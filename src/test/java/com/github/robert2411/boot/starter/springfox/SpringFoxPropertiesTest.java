package com.github.robert2411.boot.starter.springfox;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringFoxPropertiesTest {

    RestTemplate restTemplate;
    @Autowired
    SpringFoxProperties springFoxProperties;
    @LocalServerPort
    int localServerPort;

    @BeforeEach
    public void setup() {
        restTemplate = new RestTemplateBuilder()
                .rootUri("http://localhost:" + localServerPort)
                .build();
    }

    @Test
    public void getInfoTitle() {
        Assertions.assertEquals("title", springFoxProperties.getInfo().getTitle());
    }

    @Test
    public void getInfoDescription() {
        Assertions.assertEquals("description", springFoxProperties.getInfo().getDescription());
    }

    @Test
    public void getInfoVersion() {
        Assertions.assertEquals("version", springFoxProperties.getInfo().getVersion());
    }

    @Test
    public void getInfoTermsOfServiceUrl() {
        Assertions.assertEquals("termsOfServiceUrl", springFoxProperties.getInfo().getTermsOfServiceUrl());
    }

    @Test
    public void getInfoContactName() {
        Assertions.assertEquals("name", springFoxProperties.getInfo().getContact().getName());
    }

    @Test
    public void getInfoContactEmail() {
        Assertions.assertEquals("email", springFoxProperties.getInfo().getContact().getEmail());
    }

    @Test
    public void getInfoContactUrl() {
        Assertions.assertEquals("url", springFoxProperties.getInfo().getContact().getUrl());
    }

    @Test
    public void getInfoLicenseName() {
        Assertions.assertEquals("name", springFoxProperties.getInfo().getLicense().getName());
    }

    @Test
    public void getInfoLicenseUrl() {
        Assertions.assertEquals("url", springFoxProperties.getInfo().getLicense().getUrl());
    }

    @Test
    public void getConfigPaths() {
        Assertions.assertEquals("/api/.*", springFoxProperties.getConfig().getPaths());
    }

    @Test
    public void getConfigDocumentationType() {
        Assertions.assertEquals("swagger", springFoxProperties.getConfig().getDocumentationType());
    }

    @Test
    public void checkIfJsonPathExist() {
        ResponseEntity<String> response = restTemplate.getForEntity("/v2/api-docs", String.class);
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void checkIfUiPathExist() {
        ResponseEntity<String> response = restTemplate.getForEntity("/swagger-ui/", String.class);
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
    }
}