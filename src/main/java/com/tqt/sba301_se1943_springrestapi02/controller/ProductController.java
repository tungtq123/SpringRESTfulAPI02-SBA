package com.tqt.sba301_se1943_springrestapi02.controller;

import com.tqt.sba301_se1943_springrestapi02.dto.ProductDTO;
import com.tqt.sba301_se1943_springrestapi02.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/products")
@RestController
@Tag(name = "Product API", description = "Product API")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostConstruct
    public void init() {

    }

    @GetMapping
    @Operation(
            tags = {"Product Management"},
            description = "",
            requestBody =  @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "", content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @io.swagger.v3.oas.annotations.media.Schema(
                            type = "object",
                            implementation = ProductDTO.class))
            )),
            summary = "Get all products",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation"),
                    @ApiResponse(responseCode = "404", description = "Product not found")
            },
            parameters = @Parameter(name = "", allowEmptyValue = true)
    )
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        System.out.println("Fetching all products...");
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        ProductDTO product = productService.getProductById(id);
        return product != null ? ResponseEntity.ok(product): ResponseEntity.notFound().build();
    }
    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> search(@RequestParam(name = "name") String name,
                                                   @RequestParam(name = "page") int page,
                                                   @RequestParam(name = "size") int size) {
        List<ProductDTO> products = productService.searchProducts(name, page, size);
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        ProductDTO existingProduct = productService.updateProduct(id, productDTO);
        if (existingProduct != null) {
            return ResponseEntity.ok(existingProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
         int result = productService.deleteProduct(id);
         if (result > 0) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
