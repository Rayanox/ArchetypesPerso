package com.rb.domainproject.projectname.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:placeholders.properties")
@ComponentScan(basePackages = {"com.rb.domainproject.projectname"})
public class AppConfig {
	
	@Value("${facebook.username}")
	public String username;

	@Value("${facebook.password}")
	public String password;
}
