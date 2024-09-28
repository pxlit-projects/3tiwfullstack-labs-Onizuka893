package be.pxl.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "be.pxl.services")
public class SpringCloudPxlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudPxlApplication.class, args);
	}

}
