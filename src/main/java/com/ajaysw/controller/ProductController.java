package com.ajaysw.controller;

import com.ajaysw.model.Product;
import com.ajaysw.model.payload.ProductDTO;
import com.ajaysw.model.payload.ProductResponse;
import com.ajaysw.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping("/admin/{categoryId}/product")
    public ResponseEntity<ProductDTO> addProduct(
            @RequestBody ProductDTO productDTO,
            @PathVariable Long categoryId
    ) {
        ProductDTO savedProductDTO = productService.addProduct(categoryId, productDTO);
        return new ResponseEntity<>(savedProductDTO, HttpStatus.CREATED);
    }

    @GetMapping("/public/products")
    public ResponseEntity<ProductResponse> getAllProducts(){
        ProductResponse productResponse =productService.getAllProducts();
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping("/public/categories/{categoryId}/products")
    public ResponseEntity<ProductResponse> getProductByCategory(
            @PathVariable Long categoryId
    ){
        ProductResponse productResponse =  productService.searchByCategoryId(categoryId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping("/public/products/keyword/{keyword}")
    public ResponseEntity<ProductResponse> getProductByKeyword(
            @PathVariable String keyword
    ){
        ProductResponse productResponse = productService.searchProductByKeyword(keyword);
        return  new ResponseEntity<>(productResponse, HttpStatus.FOUND);
    }

    @PutMapping("/admin/products/{productId}")
    public ResponseEntity<ProductDTO> updateProduct(
            @RequestBody ProductDTO productDTO,
            @PathVariable Long productId) {
        ProductDTO updatedProductDTO = productService.updateProduct(productId, productDTO);
        return new ResponseEntity<>(updatedProductDTO, HttpStatus.OK);
    }

    @DeleteMapping("/admin/products/{productID}")
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable Long productID) {

        ProductDTO deletedProduct =  productService.deleteProductById(productID);
        return new ResponseEntity<>(deletedProduct, HttpStatus.NO_CONTENT);
    }


    @PutMapping("/products/{productId}/image")
    public ResponseEntity<ProductDTO> updateProductImage(
            @PathVariable Long productId,
            @RequestParam("image") MultipartFile image){

        ProductDTO updatedProduct =  productService.updateProductImage(productId,image);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }


}
