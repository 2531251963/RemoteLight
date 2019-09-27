package org.easyarch.euraka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurakaApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurakaApplication.class).web(true).run(args);
    }

}
