package main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import main.core.ThreadCore;

@ComponentScan(basePackages = {"com.rb.common.api", "main"})
@SpringBootApplication
public class Application {

	ThreadCore predictionsFeeder;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
