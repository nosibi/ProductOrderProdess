package com.OrderProcess.service.impl;

import com.OrderProcess.dao.MemberDAO;
import com.OrderProcess.dao.OrderDAO;
import com.OrderProcess.dao.ProductDAO;
import com.OrderProcess.data.dto.OrderDTO;
import com.OrderProcess.data.entity.Member;
import com.OrderProcess.data.entity.Order;
import com.OrderProcess.data.responseDTO.OrderResponseDTO;
import com.OrderProcess.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private MemberDAO memberDAO;
    @Autowired
    private ProductDAO productDAO;

    @Override
    public void createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setQuantity(orderDTO.getQuantity());
        order.setMember(memberDAO.findMember(orderDTO.getMemberId()));
        order.setProduct(productDAO.findProduct(orderDTO.getProductId()));

        orderDAO.createOrder(order);
    }

    @Override
    public OrderResponseDTO findOrder(Long orderId) {
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        Order foundOrder = orderDAO.findOrder(orderId);
        orderResponseDTO.setId(foundOrder.getId());
        orderResponseDTO.setQuantity(foundOrder.getQuantity());
        orderResponseDTO.setMemberName(foundOrder.getMember().getName());
        orderResponseDTO.setProductName(foundOrder.getProduct().getName());
        return orderResponseDTO;
    }

    @Override
    public void updateOrder(Long orderId, Integer quantity, Long productId) {
        orderDAO.updateOrder(orderId,quantity,productId);
    }

    @Override
    public void cancelOrder(Long orderId) {
        orderDAO.cancelOrder(orderId);
    }
}
