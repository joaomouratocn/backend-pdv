package br.com.arthivia.backend_pdv.util;

import br.com.arthivia.backend_pdv.models.dtos.ProductInsertDto;
import br.com.arthivia.backend_pdv.models.entitys.ProductEntity;

public class Mapper {
    public static ProductInsertDto toProductDto(ProductEntity entity) {
        return new ProductInsertDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getBarcode(),
                entity.getCostPrice(),
                entity.getSalePrice(),
                entity.getStockQuantity(),
                entity.getMinStock(),
                entity.getEnable(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static ProductEntity toProductEntity(ProductInsertDto productInsertDto) {
        return new ProductEntity(
                productInsertDto.id(),
                productInsertDto.name(),
                productInsertDto.description(),
                productInsertDto.barcode(),
                productInsertDto.costPrice(),
                productInsertDto.salePrice(),
                productInsertDto.stockQuantity(),
                productInsertDto.minStock(),
                productInsertDto.enable(),
                productInsertDto.createdAt(),
                productInsertDto.updatedAt()
        );
    }
}
