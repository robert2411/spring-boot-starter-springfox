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


}

//swagger:
//        version: version
//        termsOfServiceUrl: termsOfServiceUrl
//        contact:
//        name: name
//        url: url
//        email: email
//        license:
//        name: name
//        url: url