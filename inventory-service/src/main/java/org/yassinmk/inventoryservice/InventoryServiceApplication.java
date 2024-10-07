package org.yassinmk.inventoryservice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.yassinmk.inventoryservice.entitie.Product;
import org.yassinmk.inventoryservice.repository.ProductRepository;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@RequiredArgsConstructor
public class InventoryServiceApplication {
	private final ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(){
		return args -> {
			for (int i = 0; i < 10; i++) {
				productRepository.saveAll(
						List.of(
						Product.builder()
								.name("Computer " + i)
								.price(100 +Math.random()*1000)
								.quantity(10 + (int)(Math.random()*10))
								.build()
						)
				);
			}
		};
	}
}
