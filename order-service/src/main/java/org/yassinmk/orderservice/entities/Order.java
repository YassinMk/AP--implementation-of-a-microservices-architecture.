package org.yassinmk.orderservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.yassinmk.orderservice.enums.OrderStatus;
import org.yassinmk.orderservice.model.Customer;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private Long customerId;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @OneToMany(mappedBy = "orders")
    private List<ProductItems> productItems;
    @Transient
    private Customer customer;

}
