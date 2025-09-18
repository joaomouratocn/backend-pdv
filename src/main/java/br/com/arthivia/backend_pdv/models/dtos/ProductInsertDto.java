package br.com.arthivia.backend_pdv.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ProductInsertDto(
        @NotNull
        UUID id,
        @NotNull
        @NotBlank
        String name,
        String description,
        @NotNull
        @NotBlank
        String barcode,
        @NotNull
        BigDecimal costPrice,
        @NotNull
        BigDecimal salePrice,
        @NotNull
        BigDecimal stockQuantity,
        BigDecimal minStock,
        Boolean enable,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public ProductInsertDto {
        if (enable == null) {
            enable = true;
        }
    }
}
