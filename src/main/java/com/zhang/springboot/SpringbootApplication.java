package com.zhang.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.zhang.springboot"})
public class SpringbootApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
     SpringApplication.run(SpringbootApplication.class, args);
  }

  @Override//为了打包springboot项目
  protected SpringApplicationBuilder configure(
      SpringApplicationBuilder builder) {
    return builder.sources(this.getClass());
  }

}
