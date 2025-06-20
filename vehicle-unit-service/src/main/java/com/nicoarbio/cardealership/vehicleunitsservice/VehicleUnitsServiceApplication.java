package com.nicoarbio.cardealership.vehicleunitsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class VehicleUnitsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleUnitsServiceApplication.class, args);
	}

}
