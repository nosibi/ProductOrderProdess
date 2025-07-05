package com.OrderProcess.dao.impl;

import com.OrderProcess.dao.ProductDAO;
import com.OrderProcess.data.entity.Product;
import com.OrderProcess.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDAOImpl implements ProductDAO {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProductPrice(Long id, Integer price) {
        Product updatedProduct = productRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 상품 없음"));
        updatedProduct.setPrice(price);
        productRepository.save(updatedProduct);
    }

    @Override
    public void updateProductStock(Long id, Integer stock) {
        Product updatedProduct = productRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 상품 없음"));
        updatedProduct.setStock(stock);
        productRepository.save(updatedProduct);
    }

    @Override
    public Product findProduct(Long id) {
        return productRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 상품 없음"));
    }

    @Override
    public void deleteProduct(Long id) {
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("해당 상품 없음");
        }
    }
}
