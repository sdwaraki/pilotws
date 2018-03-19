package com.sumanth.projects.pilotws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = { "com.sumanth.projects" })
public class PilotwsApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PilotwsApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(PilotwsApplication.class, args);
	}
}
