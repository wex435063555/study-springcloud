package com.wrx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServer_3344 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServer_3344.class,args);
    }
}
