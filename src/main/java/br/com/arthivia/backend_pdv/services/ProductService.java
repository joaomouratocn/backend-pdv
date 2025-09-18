package br.com.arthivia.backend_pdv.services;

import br.com.arthivia.backend_pdv.models.dtos.ProductDto;
import br.com.arthivia.backend_pdv.models.dtos.SuccessResponse;
import br.com.arthivia.backend_pdv.repositorys.ProductRepository;
import br.com.arthivia.backend_pdv.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> getAll() {
        return productRepository.findAll()
                .stream()
                .map(Mapper::toProductDto)
                .toList();
    }

    public void saveProduct(ProductDto productDto) {
        var prodEntity = Mapper.toProductEntity(productDto);
        productRepository.save(prodEntity);
    }
}
