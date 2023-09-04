package com.farmequipmentrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.farmequipmentrental.utils.FileUploadProperties;

@SpringBootApplication
@EnableJpaAuditing
@EnableWebMvc
@EnableConfigurationProperties({
    FileUploadProperties.class
})
public class FarmEquipmentRentalBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmEquipmentRentalBackendApplication.class, args);
	}

}
