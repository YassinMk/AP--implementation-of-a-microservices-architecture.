package org.yassinmk.orderservice.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
public class Customer {

    private Long Id;
    private String name;
    private String lastName;
    private String email;
}
