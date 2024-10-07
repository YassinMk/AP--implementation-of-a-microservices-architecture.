package org.yassinmk.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yassinmk.orderservice.entities.Order;
import org.yassinmk.orderservice.entities.ProductItems;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
