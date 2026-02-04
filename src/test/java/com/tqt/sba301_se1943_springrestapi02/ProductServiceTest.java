package com.tqt.sba301_se1943_springrestapi02;

import com.tqt.sba301_se1943_springrestapi02.dto.ProductDTO;
import com.tqt.sba301_se1943_springrestapi02.service.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;
    @Test
    void getAllProductsTest() {
        List<ProductDTO> products = productService.getAllProducts();
        Assertions.assertThat(products).isNotNull();
    }
}
