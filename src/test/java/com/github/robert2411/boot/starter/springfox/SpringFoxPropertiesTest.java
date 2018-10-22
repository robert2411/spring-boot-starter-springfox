package com.github.robert2411.boot.starter.springfox;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringFoxPropertiesTest {

    @Autowired
    SpringFoxProperties springFoxProperties;

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


}