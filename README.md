Build status: [![build_status](https://travis-ci.org/robert2411/spring-boot-starter-springfox.svg?branch=master)](https://travis-ci.org/robert2411/spring-boot-starter-springfox) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.robert2411/spring-boot-starter-springfox/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.robert2411/spring-boot-starter-springfox)
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Frobert2411%2Fspring-boot-starter-springfox.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2Frobert2411%2Fspring-boot-starter-springfox?ref=badge_shield)


The core of this project is build around the springfox project: https://github.com/springfox/springfox

The goal of this project is to make it easier to integrate springfox with spring boot applications

## Usage
Add the dependency to your project
```
<dependency>
    <groupId>com.github.robert2411</groupId>
    <artifactId>spring-boot-starter-springfox</artifactId>
</dependency>
```

 - Go to `/swagger-ui/` to see the ui
 - Go to `/v2/api-docs` to see the json
 
### Config properties

```
swagger:
  info:
    title: title
    description: description
    version: version
    termsOfServiceUrl: termsOfServiceUrl
    contact:
      name: name
      url: url
      email: email
    license:
      name: name
      url: url
  config:
    paths: /api/.*
    documentation-type: swagger
```
The options for documentation-type are: swagger, openApi

## License
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Frobert2411%2Fspring-boot-starter-springfox.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2Frobert2411%2Fspring-boot-starter-springfox?ref=badge_large)