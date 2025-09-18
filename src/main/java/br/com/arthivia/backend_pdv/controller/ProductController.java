package br.com.arthivia.backend_pdv.controller;

import br.com.arthivia.backend_pdv.models.dtos.ProductInsertDto;
import br.com.arthivia.backend_pdv.infra.SuccessResponse;
import br.com.arthivia.backend_pdv.models.dtos.ProductUpdateDto;
import br.com.arthivia.backend_pdv.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductInsertDto>> getAllProducts() {
        var allProducts = productService.getAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity<SuccessResponse> saveProduct(@RequestBody @Validated ProductInsertDto productInsertDto) {
        productService.saveProduct(productInsertDto);
        return ResponseEntity.ok(new SuccessResponse("Success"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse> updateProduct(
            @PathVariable @Validated UUID id,
            @RequestBody @Validated ProductUpdateDto productUpdateDto
    ) {
        productService.updateProduct(id, productUpdateDto);
        return ResponseEntity.ok(new SuccessResponse("Success"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deleteProduct(@PathVariable @Validated UUID id){
        productService.deleteProduct(id);
        return ResponseEntity.ok(new SuccessResponse("Success"));
    }
}