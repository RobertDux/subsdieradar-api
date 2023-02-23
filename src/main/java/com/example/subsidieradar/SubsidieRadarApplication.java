package com.example.subsidieradar;

import com.example.subsidieradar.application.SubsidieService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SubsidieRadarApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SubsidieRadarApplication.class, args);
		SubsidieService.fillWithTestdata();
	}
}