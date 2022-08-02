package com.example.uploadfile;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.example.uploadfile.storage.StorageProperties;
import com.example.uploadfile.storage.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class UploadfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadfileApplication.class, args);
	}
	@Bean
	CommandLineRunner init(StorageService storageService){
		return (args)->{
			storageService.deleteAll();
			storageService.init();
		};
	}

}