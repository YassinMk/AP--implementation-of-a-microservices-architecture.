package org.yassinmk.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yassinmk.customerservice.entitie.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}