package com.ajaysw.service;

import com.ajaysw.model.payload.ProductDTO;
import com.ajaysw.model.payload.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, ProductDTO product);

    ProductResponse getAllProducts();

    ProductResponse searchByCategoryId(Long categoryId);

    ProductResponse searchProductByKeyword(String keyword);

    ProductDTO updateProduct(Long productId, ProductDTO product);

    ProductDTO deleteProductById(Long productID);

    ProductDTO updateProductImage(Long productId, MultipartFile image);
}
