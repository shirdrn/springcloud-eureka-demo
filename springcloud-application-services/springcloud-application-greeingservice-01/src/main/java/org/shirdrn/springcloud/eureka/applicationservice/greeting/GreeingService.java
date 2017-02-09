package org.shirdrn.springcloud.eureka.applicationservice.greeting;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableAutoConfiguration
public class GreeingService {
	
    @RequestMapping(method = RequestMethod.GET, value = "/greeting/{name}")
    public String greet(@PathVariable("name") String name) {
        return "::01:: Hello, " + name + "!";
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(GreeingService.class).web(true).run(args);
    }
}
