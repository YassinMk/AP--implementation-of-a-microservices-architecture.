package org.yassinmk.orderservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.yassinmk.orderservice.entities.Order;
import org.yassinmk.orderservice.entities.ProductItems;
import org.yassinmk.orderservice.enums.OrderStatus;
import org.yassinmk.orderservice.model.Customer;
import org.yassinmk.orderservice.model.Product;
import org.yassinmk.orderservice.repository.OrderRepository;
import org.yassinmk.orderservice.repository.ProductItemRepository;
import org.yassinmk.orderservice.service.CustomerRestClientService;
import org.yassinmk.orderservice.service.InventoryRestClientService;

import java.util.Date;
import java.util.List;
import java.util.Random;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            OrderRepository orderRepository,
            ProductItemRepository productItemRepository,
            CustomerRestClientService customerRestClientService,
            InventoryRestClientService inventoryRestClientService
    ){
        return args -> {
            List<Customer> customers = customerRestClientService.getCustomers();
            List<Product> products = inventoryRestClientService.getProducts().getContent().stream().toList();
            Long customerId = customers.get(1).getId();
            Random random = new Random();
            Customer customer = customerRestClientService.getCustomerById(customerId);
            for (int  i = 0; i < 20; i++) {
               Order order = new Order().builder()
                       .customerId(customers.get(random.nextInt(customers.size())).getId())
                       .createdAt(new Date())
                       .status(Math.random() < 0.5 ? OrderStatus.IN_PROGRESS: OrderStatus.COMPLETED)
                       .build();
                orderRepository.save(order);
                for (int j = 0; j < products.size(); j++) {
                    ProductItems productItems = new ProductItems().builder()
                            .product(products.get(j))
                            .productId(products.get(j).getId())
                            .price(products.get(j).getPrice())
                            .quantity(random.nextInt(100))
                            .order(order)
                            .build();
                }
            }

        };
    }


}
