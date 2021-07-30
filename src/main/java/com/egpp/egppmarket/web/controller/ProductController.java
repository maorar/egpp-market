package com.egpp.egppmarket.web.controller;

import com.egpp.egppmarket.domain.Product;
import com.egpp.egppmarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
//    public List<Product> getAll(){
//        return productService.getAll();
//     }
        public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
       }

    @GetMapping("/{id}")
//     public Optional<Product> getProduct(@PathVariable("id") int productId) {
//        return productService.getProduct(productId);
//     }
        public ResponseEntity<Product> getProduct(@PathVariable("id") int productId) {
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

     @GetMapping("/category/{categoryId}")
//     public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
//        return productService.getByCategory(categoryId);
//     }
     public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
         return productService.getByCategory(categoryId)
                 .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
     }
    @PostMapping("/save")
//     public Product save(@RequestBody Product product) {
//        return productService.save(product);
//     }
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
//     public boolean delete(@PathVariable("id") int productId) {
//        return  productService.delete(productId);
//     }
    public ResponseEntity delete(@PathVariable("id") int productId) {
        if (productService.delete(productId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }



}
