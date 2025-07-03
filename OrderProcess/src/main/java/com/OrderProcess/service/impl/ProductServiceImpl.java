package com.OrderProcess.service.impl;

import com.OrderProcess.dao.ProductDAO;
import com.OrderProcess.data.dto.ProductDTO;
import com.OrderProcess.data.entity.Product;
import com.OrderProcess.data.responseDTO.ProductResponseDTO;
import com.OrderProcess.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;

    @Override
    public void saveProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        productDAO.saveProduct(product);
    }

    @Override
    public void updateProductPrice(Long id, Integer price) {
        productDAO.updateProductPrice(id, price);
    }

    @Override
    public void updateProductStock(Long id, Integer stock) {
        productDAO.updateProductStock(id, stock);
    }

    @Override
    public ProductResponseDTO findProduct(Long id) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        Product product = productDAO.findProduct(id);
        productResponseDTO.setId(product.getId());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setStock(product.getStock());
        return productResponseDTO;
    }

    @Override
    public void deleteProduct(Long id) {
        productDAO.deleteProduct(id);
    }
}