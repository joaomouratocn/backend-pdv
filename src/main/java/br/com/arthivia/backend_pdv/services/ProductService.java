package br.com.arthivia.backend_pdv.services;

import br.com.arthivia.backend_pdv.infra.exceptions.customs.ExistProductIdException;
import br.com.arthivia.backend_pdv.infra.exceptions.customs.NotProductFoundException;
import br.com.arthivia.backend_pdv.models.dtos.ProductInsertDto;
import br.com.arthivia.backend_pdv.models.dtos.ProductUpdateDto;
import br.com.arthivia.backend_pdv.repositorys.ProductRepository;
import br.com.arthivia.backend_pdv.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductInsertDto> getAll() {
        return productRepository.findAll()
                .stream()
                .map(Mapper::toProductDto)
                .toList();
    }

    public void saveProduct(ProductInsertDto productInsertDto) {
        var prodExist = productRepository.findById(productInsertDto.id()).isPresent();
        if(prodExist){
            throw new ExistProductIdException("Id already exists");
        }
        var prodEntity = Mapper.toProductEntity(productInsertDto);
        productRepository.save(prodEntity);
    }

    public void updateProduct(UUID id, ProductUpdateDto productUpdateDto){
        var prodExist = productRepository.findById(id).orElseThrow(() -> new NotProductFoundException("Product not found!"));

        prodExist.setName(productUpdateDto.name());
        prodExist.setDescription(productUpdateDto.description());
        prodExist.setBarcode(productUpdateDto.barcode());
        prodExist.setCostPrice(productUpdateDto.costPrice());
        prodExist.setSalePrice(productUpdateDto.salePrice());
        prodExist.setMinStock(productUpdateDto.minStock());
        prodExist.setCreatedAt(productUpdateDto.updatedAt());

        productRepository.save(prodExist);
    }

    public void deleteProduct(UUID id) {
        var prodExist = productRepository.findById(id).orElseThrow(() -> new NotProductFoundException("Product not found!"));
        prodExist.setEnable(false);
        productRepository.save(prodExist);
    }
}
