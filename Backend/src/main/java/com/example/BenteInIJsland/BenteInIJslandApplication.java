package com.example.BenteInIJsland;

import com.example.BenteInIJsland.filestorage.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = "com.example.BenteInIjsland")
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class  BenteInIJslandApplication {

	public static void main(String[] args) {
		SpringApplication.run(BenteInIJslandApplication.class, args);
	}

}
