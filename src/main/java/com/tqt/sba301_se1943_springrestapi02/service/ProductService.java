package com.sba301.service;

import com.sba301.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Long id);
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    int deleteProduct(Long id);
    List<ProductDTO> searchProducts(String name, int page, int size);
}
