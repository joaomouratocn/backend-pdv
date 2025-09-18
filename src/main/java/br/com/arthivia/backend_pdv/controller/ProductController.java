package br.com.arthivia.backend_pdv.controller;

import br.com.arthivia.backend_pdv.models.dtos.ProductDto;
import br.com.arthivia.backend_pdv.models.dtos.SuccessResponse;
import br.com.arthivia.backend_pdv.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        var allProducts = productService.getAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity<SuccessResponse> saveProduct(@RequestBody @Validated ProductDto productDto) {
        productService.saveProduct(productDto);
        return ResponseEntity.ok(new SuccessResponse("Success"));
    }
}
