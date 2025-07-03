package com.OrderProcess.dao;

import com.OrderProcess.data.entity.Order;

public interface OrderDAO {
    //주문을 입력, 생성하는 기능
    void createOrder(Order order);
    //주문 정보를 조회
    Order findOrder(Long orderId);
    //주문 정보 수정(수량, 상품)
    void updateOrder(Long orderId, Integer quantity, Long productId);
    //주문 취소
    void cancelOrder(Long orderId);
}
