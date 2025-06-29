package com.OrderProcess.service.impl;

import com.OrderProcess.dao.MemberDAO;
import com.OrderProcess.dao.OrderDAO;
import com.OrderProcess.dao.ProductDAO;
import com.OrderProcess.data.dto.OrderDTO;
import com.OrderProcess.data.entity.Member;
import com.OrderProcess.data.entity.Order;
import com.OrderProcess.data.entity.Product;
import com.OrderProcess.data.responseDTO.OrderResponseDTO;
import com.OrderProcess.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        Member member = memberDAO.findMember(orderDTO.getMemberId());
        Product product = productDAO.findProduct(orderDTO.getProductId());
        //회원등급에 따라 할인가 적용(골드 30%, 실버 20%, 브론즈 10%), 비용은 주문수량 * 가격(할인 적용)
        Integer discountPrice = orderDTO.getQuantity() * (product.getPrice() * (100- member.getGrade().getDiscountRate())/100);

        order.setQuantity(orderDTO.getQuantity());
        order.setMember(member);
        order.setProduct(product);
        order.setCost(discountPrice);
        order.setMemberName(member.getName());
        order.setProductName(product.getName());

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
        orderResponseDTO.setCost(foundOrder.getCost());
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

    @Override
    public List<OrderResponseDTO> findOrderList(String memberName) {
        List<OrderResponseDTO> responseDTOList = new ArrayList<>();
        List<Order> orderList = orderDAO.findOrderList(memberName);

        for(int i = 0; i < orderList.size(); i++){
            OrderResponseDTO responseDTO = new OrderResponseDTO();
            responseDTO.setId(orderList.get(i).getId());
            responseDTO.setQuantity(orderList.get(i).getQuantity());
            responseDTO.setMemberName(orderList.get(i).getMember().getName());
            responseDTO.setProductName(orderList.get(i).getProduct().getName());
            responseDTO.setCost(orderList.get(i).getCost());
            responseDTOList.add(responseDTO);
        }
        return responseDTOList;
    }
}
