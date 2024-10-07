package org.yassinmk.orderservice.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.yassinmk.orderservice.entities.Order;
import org.yassinmk.orderservice.repository.OrderRepository;
import org.yassinmk.orderservice.repository.ProductItemRepository;
import org.yassinmk.orderservice.service.CustomerRestClientService;
import org.yassinmk.orderservice.service.InventoryRestClientService;

@RestController
@RequiredArgsConstructor
public class OrderRestController {
    private final OrderRepository orderRepository;
    private final  ProductItemRepository productItemRepository;
    private final CustomerRestClientService customerRestClientService;
    private final  InventoryRestClientService inventoryRestClientService;
     @GetMapping("/fullOrders/{id}")
    public Order getFullOrder(@PathVariable Long id) {
         Order order = orderRepository.findById(id).get();
         order.setCustomer(customerRestClientService.getCustomerById(order.getCustomerId()));
         order.getProductItems().forEach(pi -> {
             pi.setProduct(inventoryRestClientService.getProductById(pi.getProductId()));
             pi.setProduct(pi.getProduct());
         });
         return order;
     }

}
