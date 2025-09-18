package br.com.arthivia.backend_pdv.models.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ProductDto (
        UUID id,
        String name,
        String description,
        String barcode,
        BigDecimal costPrice,
        BigDecimal salePrice,
        BigDecimal stockQuantity,
        LocalDateTime createdAt
) {
    public ProductDto {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}
