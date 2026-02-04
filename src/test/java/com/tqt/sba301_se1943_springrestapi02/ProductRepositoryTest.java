package com.tqt.sba301_se1943_springrestapi02;

import com.tqt.sba301_se1943_springrestapi02.entity.Product;
import com.tqt.sba301_se1943_springrestapi02.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //Su dung neu test vơi database
public class ProductRepositoryTest {
     @Autowired
     private ProductRepository productRepository;
     @Test
     void findByNameContainingTest() {
         Pageable pageable = PageRequest.of(0, 10);
         Page<Product> products = productRepository.findByNameContaining("iphone", pageable);
         assertThat(products).isNotNull();
     }

}
