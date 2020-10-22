package com.github.robert2411.boot.starter.springfox;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringFoxPropertiesTest {

    RestTemplate restTemplate;
    @Autowired
    SpringFoxProperties springFoxProperties;
    @LocalServerPort
    int localServerPort;

    @Before
    public void setup() {
        restTemplate = new RestTemplateBuilder()
                .rootUri("http://localhost:" + localServerPort)
                .build();
    }

    @Test
    public void getInfoTitle() {
        Assert.assertEquals("title", springFoxProperties.getInfo().getTitle());
    }

    @Test
    public void getInfoDescription() {
        Assert.assertEquals("description", springFoxProperties.getInfo().getDescription());
    }

    @Test
    public void getInfoVersion() {
        Assert.assertEquals("version", springFoxProperties.getInfo().getVersion());
    }

    @Test
    public void getInfoTermsOfServiceUrl() {
        Assert.assertEquals("termsOfServiceUrl", springFoxProperties.getInfo().getTermsOfServiceUrl());
    }

    @Test
    public void getInfoContactName() {
        Assert.assertEquals("name", springFoxProperties.getInfo().getContact().getName());
    }

    @Test
    public void getInfoContactEmail() {
        Assert.assertEquals("email", springFoxProperties.getInfo().getContact().getEmail());
    }

    @Test
    public void getInfoContactUrl() {
        Assert.assertEquals("url", springFoxProperties.getInfo().getContact().getUrl());
    }

    @Test
    public void getInfoLicenseName() {
        Assert.assertEquals("name", springFoxProperties.getInfo().getLicense().getName());
    }

    @Test
    public void getInfoLicenseUrl() {
        Assert.assertEquals("url", springFoxProperties.getInfo().getLicense().getUrl());
    }

    @Test
    public void getConfigPaths() {
        Assert.assertEquals("/api/.*", springFoxProperties.getConfig().getPaths());
    }

    @Test
    public void getConfigDocumentationType() {
        Assert.assertEquals("swagger", springFoxProperties.getConfig().getDocumentationType());
    }

    @Test
    public void checkIfJsonPathExist() {
        ResponseEntity<String> response = restTemplate.getForEntity("/v2/api-docs", String.class);
        Assert.assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void checkIfUiPathExist() {
        ResponseEntity<String> response = restTemplate.getForEntity("/swagger-ui/", String.class);
        Assert.assertTrue(response.getStatusCode().is2xxSuccessful());
    }
}