package org.yassinmk.customerservice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.yassinmk.customerservice.entitie.Customer;
import org.yassinmk.customerservice.repository.CustomerRepository;

@SpringBootApplication
@RequiredArgsConstructor
@EnableDiscoveryClient
public class CustomerServiceApplication {
	private  final CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(){
		return args -> {
			for (int i = 0; i < 10; i++) {
				Customer customer = new Customer().builder()
						.name("Customer "+i)
						.email("customer12@test.com")
						.lastName("Customer "+i)
						.build();
				customerRepository.save(customer);
			}

		};
	}
}
