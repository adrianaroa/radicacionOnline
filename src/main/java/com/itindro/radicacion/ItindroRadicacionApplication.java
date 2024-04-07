package com.itindro.radicacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ItindroRadicacionApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ItindroRadicacionApplication.class, args);
	}

  @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ItindroRadicacionApplication.class);
    }
  
  	private static Class<ItindroRadicacionApplication> application = ItindroRadicacionApplication.class;

}
