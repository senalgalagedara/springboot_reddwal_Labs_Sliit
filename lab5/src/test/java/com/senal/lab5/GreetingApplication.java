package com.senal.lab5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication  
public class GreetingApplication {

    private static RestTemplate httpClient = null;

    private static String baseURL = "http://localhost:8080";

    private static String defaultGreetingURL = "greeting";
    private static String nameGreetingURL = "greeting/name?name=Senal";

    public static void main(String[] args){
        SpringApplication.run(GreetingApplication.class, args);
        makeCalls();
    }

    private static RestTemplate getHttpClient() {
        if (httpClient == null) {
            httpClient = new RestTemplate();
        }
        return httpClient;
    }

    private static Greeting getGreeting(String url) {
        return getHttpClient().getForObject(baseURL + "/" + url, Greeting.class);
    }

    public static void makeCalls() {
        Greeting recivedGreeting1 = getGreeting(defaultGreetingURL);
        Greeting recivedGreeting2 = getGreeting(nameGreetingURL);

        System.out.println(recivedGreeting1.content());
        System.out.println(recivedGreeting2.content());
    }
}