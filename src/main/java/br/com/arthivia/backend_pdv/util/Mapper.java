package br.com.arthivia.backend_pdv.util;

import br.com.arthivia.backend_pdv.models.dtos.ProductDto;
import br.com.arthivia.backend_pdv.models.entitys.ProductEntity;

public class Mapper {
    public static ProductDto toProductDto(ProductEntity entity) {
        return new ProductDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getBarcode(),
                entity.getCostPrice(),
                entity.getSalePrice(),
                entity.getStockQuantity(),
                entity.getCreatedAt()
        );
    }

    public static ProductEntity toProductEntity(ProductDto productDto) {
        return new ProductEntity(
                productDto.id(),
                productDto.name(),
                productDto.description(),
                productDto.barcode(),
                productDto.costPrice(),
                productDto.salePrice(),
                productDto.stockQuantity(),
                productDto.createdAt()
        );
    }
}
