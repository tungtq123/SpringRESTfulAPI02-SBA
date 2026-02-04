package com.sba301.service.impl;

import com.sba301.dto.ProductDTO;
import com.sba301.entity.Category;
import com.sba301.entity.Product;
import com.sba301.repository.CategoryRepository;
import com.sba301.repository.ProductRepository;
import com.sba301.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> products = productRepository.findAll()
                .stream().map(product -> {
                    Category category = product.getCategory();
                    return new ProductDTO(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getDescription(),
                            category == null ? null : category.getId()
                );}).toList();
        return products;
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            Category category = product.getCategory();
            return new ProductDTO(
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getDescription(),
                    category == null ? null : category.getId()
            );
        }
        return null;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }
        Category category = null;
        if (productDTO.getCategoryId() != null) {
            category = categoryRepository.findById(productDTO.getCategoryId()).orElse(null);
        }
        Product product = new Product(
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getDescription(),
                category
        );
        productRepository.save(product);
        productDTO.setId(product.getId());
        return productDTO;
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        return null;
    }

    @Override
    public int deleteProduct(Long id) {
        return 0;
    }

    @Override
    public List<ProductDTO> searchProducts(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Product> products = productRepository.findByNameContaining(name, pageable).getContent();
        return products.stream().map(product -> {
            Category category = product.getCategory();
            return new ProductDTO(product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getDescription(),
                    category == null ? null : category.getId());
        }).toList();
    }
}
