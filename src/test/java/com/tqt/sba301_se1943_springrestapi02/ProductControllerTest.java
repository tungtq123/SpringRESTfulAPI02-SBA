package com.tqt.sba301_se1943_springrestapi02;

import com.tqt.sba301_se1943_springrestapi02.controller.ProductController;
import com.tqt.sba301_se1943_springrestapi02.dto.ProductDTO;
import com.tqt.sba301_se1943_springrestapi02.service.ProductService;
import io.swagger.v3.core.util.Json;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private ProductService productService;

    /**
     * ID: 0001
     * Description: Test branch coverage of searchProduct methods
     * Input: pageNo= 1, pageSize = 0...
     *
     * Expected: two products
     */
    @Test
    void searchProductsTest()  {
        /**
         *
         */
        try {
            mockMvc.perform(get("/api/products/search?name=iphone&page=0&size=10")
            ).andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void getProductByIdTest() {
        try {
            mockMvc.perform(get("/api/products/{id}", 1L))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
        } catch (Exception e) {
        }
    }
    @Test
    void createProductTest() {
        try {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(1L);
            productDTO.setName("iphone");
            productDTO.setDescription("iphone");
            productDTO.setPrice(1000);
            productDTO.setCategoryId(1);
            String productJson = Json.pretty(productDTO);
            // Khi nhận vào bất kỳ ProductDTO nào, hãy trả về chính nó (hoặc một bản sao có ID)
            Mockito.when(productService.createProduct(any(ProductDTO.class))).thenReturn(productDTO);
            mockMvc.perform(post("/api/products").contentType(MediaType.APPLICATION_JSON).content(productJson))
                    .andExpect(status().isCreated())
                    .andExpect(MockMvcResultMatchers.content().json(productJson));
                    //.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
                   // .json(productJson));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void shouldCreateProduct() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("Laptop");
        productDTO.setDescription("Laptop");
        productDTO.setPrice(1000);
        productDTO.setCategoryId(1);
        String productJson = Json.pretty(productDTO);
        // 2. QUAN TRỌNG: Mock hành vi của Service
        // Khi nhận vào bất kỳ ProductDTO nào, hãy trả về chính nó (hoặc một bản sao có ID)
        Mockito.when(productService.createProduct(any(ProductDTO.class))).thenReturn(productDTO);

//       MvcResult mvcResult = mockMvc.perform(post("/api/products") // 1. RequestBuilder (POST method)
//                        .contentType(MediaType.APPLICATION_JSON) // Định dạng gửi đi
//                        .content(productJson)) // Body của request
//                .andDo(print()).andReturn(); // 2. ResultHandler (In kết quả ra console)
//        System.out.println("Result: " + mvcResult.getResponse().getContentAsString());
        mockMvc.perform(post("/api/products") // 1. RequestBuilder (POST method)
                        .contentType(MediaType.APPLICATION_JSON) // Định dạng gửi đi
                        .content(productJson)) // Body của request
                .andDo(print())
                .andExpect(status().isCreated()) // 3. ResultMatcher (Kiểm tra status 201)
               .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists()) // Kiểm tra xem JSON trả về có field id không
               .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Laptop")); // Kiểm tra dữ liệu đúng không
    }
}
