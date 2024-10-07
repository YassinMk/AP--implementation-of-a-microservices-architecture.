package org.yassinmk.inventoryservice.entitie;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Product.class, name = "fullProduct")
public interface ProductProjection {
    Long getId();
    String getName();
    double getPrice();
    int getQuantity();
}
