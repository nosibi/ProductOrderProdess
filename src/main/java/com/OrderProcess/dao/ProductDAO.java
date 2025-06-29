package com.OrderProcess.dao;

import com.OrderProcess.data.entity.Product;

public interface ProductDAO {
    //상품 정보 등록
    void saveProduct(Product product);

    //상품 가격 수정
    void updateProductPrice(Long id, Integer price);

    //상품 재고 수정
    void updateProductStock(Long id, Integer stock);

    //상품 정보 조회
    Product findProduct(Long id);

    //상품 정보 삭제
    void deleteProduct(Long id);
}
