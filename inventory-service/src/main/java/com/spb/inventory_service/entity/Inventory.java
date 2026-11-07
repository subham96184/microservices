package com.spb.inventory_service.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Inventory {

    @Id
    private Long productId;

    private Integer stock;
}