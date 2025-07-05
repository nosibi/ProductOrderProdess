package com.OrderProcess.dao;

import com.OrderProcess.data.entity.Order;

import java.util.List;

public interface OrderDAO {
    //주문을 입력, 생성하는 기능
    void createOrder(Order order);
    //주문 정보를 조회
    Order findOrder(Long orderId);
    //주문 정보 수정(수량, 상품)
    void updateOrder(Long orderId, Integer quantity, Long productId);
    //특정 상품 주문자 리스트 조회
    List<Order> findOrderList(String memberName);
    //주문 취소
    void cancelOrder(Long orderId);
}
