package com.springboot.imgupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ImgUploadApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ImgUploadApplication.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/File/**")
				.addResourceLocations("file:File/");
	}

}
