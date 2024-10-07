package org.yassinmk.orderservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.yassinmk.orderservice.config.FeignConfig;
import org.yassinmk.orderservice.config.PageWrapper;
import org.yassinmk.orderservice.model.Product;


@FeignClient(name = "INVENTORY-SERVICE" )
public interface InventoryRestClientService {
    @GetMapping("/products?projection=fullProduct")
    public PagedModel<Product> getProducts();
    @GetMapping("/products/{id}?projection=fullProduct")
    public Product getProductById(Long id);

}
