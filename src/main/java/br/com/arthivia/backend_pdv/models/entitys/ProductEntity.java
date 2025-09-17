package br.com.arthivia.backend_pdv.models.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    private UUID id;
    private String name;
    private String description;
    private String barCode;
    private BigDecimal costPrice;
    private BigDecimal salePrice;
    private BigDecimal stockQuantity;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
