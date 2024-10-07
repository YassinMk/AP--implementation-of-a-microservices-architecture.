package org.yassinmk.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.yassinmk.inventoryservice.entitie.Product;

@RepositoryRestResource
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
}
