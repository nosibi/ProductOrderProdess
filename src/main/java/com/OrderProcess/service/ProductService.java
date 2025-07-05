package com.OrderProcess.service;

import com.OrderProcess.data.dto.ProductDTO;
import com.OrderProcess.data.entity.Product;
import com.OrderProcess.data.responseDTO.ProductResponseDTO;

public interface ProductService {
    //상품 정보 등록
    void saveProduct(ProductDTO productDTO);

    //상품 가격 수정
    void updateProductPrice(Long id, Integer price);

    //상품 재고 수정
    void updateProductStock(Long id, Integer stock);

    //상품 정보 조회
    ProductResponseDTO findProduct(Long id);

    //상품 정보 삭제
    void deleteProduct(Long id);
}
