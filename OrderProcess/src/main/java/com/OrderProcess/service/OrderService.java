package com.OrderProcess.service;

import com.OrderProcess.data.dto.OrderDTO;
import com.OrderProcess.data.entity.Order;
import com.OrderProcess.data.responseDTO.OrderResponseDTO;

public interface OrderService {
    //주문을 입력, 생성하는 기능
    void createOrder(OrderDTO orderDTO);
    //주문 정보를 조회
    OrderResponseDTO findOrder(Long orderId);
    //주문 정보 수정(수량, 상품)
    void updateOrder(Long orderId, Integer quantity, Long productId);
    //주문 취소
    void cancelOrder(Long orderId);
}