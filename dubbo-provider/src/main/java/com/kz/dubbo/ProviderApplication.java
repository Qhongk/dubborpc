package com.kz.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.kz.dubbo.config.ProviderServletContextInitializer;
import com.kz.dubbo.config.SpringUtilConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.*;


@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(
        basePackages = "com.kz.dubbo")
@EnableMBeanExport(defaultDomain = "provider.kz.dubbo.com")
@Import(SpringUtilConfig.class)
@DubboComponentScan(basePackages = "com.kz.dubbo.service")
public class ProviderApplication {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(ProviderApplication.class, args);
    }

    @Bean
    public ServletContextInitializer initializer() {
        return new ProviderServletContextInitializer();
    }

}
