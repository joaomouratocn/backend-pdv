package br.com.arthivia.backend_pdv.services;

import br.com.arthivia.backend_pdv.models.dtos.ProductDto;
import br.com.arthivia.backend_pdv.repositorys.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public List<ProductDto> getAll() {
        var resultEntity = productRepository.findAll();
        return null;
    }
}
