package org.shirdrn.springcloud.eureka.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MyEurekaServer {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MyEurekaServer.class).web(true).run(args);
    }

}
