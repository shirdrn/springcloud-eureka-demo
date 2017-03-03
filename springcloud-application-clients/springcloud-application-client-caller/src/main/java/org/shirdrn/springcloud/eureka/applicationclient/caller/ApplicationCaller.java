package org.shirdrn.springcloud.eureka.applicationclient.caller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ApplicationCaller {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ApplicationCaller.class)
                .web(false)
                .run(args);
    }
}

@Component
class RestTemplateExample implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;
    private static final String GREETING_SERVICE_URI = "http://greeting.service/greeting/{name}"; 

    @Override
    public void run(String... strings) throws Exception {
    	while(true) {
    		String greetingSentence = this.restTemplate.getForObject(
    				GREETING_SERVICE_URI, 
    				String.class, 
    				"Dean Shi");
    		
    		System.out.println("Response result: " + greetingSentence);
    		
    		Thread.sleep(5000);
    	}
    }

}
