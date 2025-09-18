package br.com.arthivia.backend_pdv.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductUpdateDto(
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
        BigDecimal minStock,
        LocalDateTime updatedAt
) {}
