package com.OrderProcess.dao.impl;

import com.OrderProcess.dao.OrderDAO;
import com.OrderProcess.data.entity.Order;
import com.OrderProcess.data.entity.Product;
import com.OrderProcess.repository.MemberRepository;
import com.OrderProcess.repository.OrderRepository;
import com.OrderProcess.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createOrder(Order order) {
        //주문 수량만큼 상품 재고 감소
        Integer decreaseStock = order.getProduct().getStock() - order.getQuantity();
        Product updateProduct = productRepository.findById(order.getProduct().getId()).orElseThrow(()->new IllegalArgumentException("해당 상품 없음"));
        updateProduct.setStock(decreaseStock);
        productRepository.save(updateProduct);
        orderRepository.save(order);
    }

    @Override
    public Order findOrder(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(()-> new IllegalArgumentException("해당 주문이 존재하지 않음"));
    }

    @Override
    public void updateOrder(Long orderId, Integer quantity, Long productId) {
        Order foundOrder = orderRepository.findById(orderId).orElseThrow(()-> new IllegalArgumentException("해당 주문이 존재하지 않음"));
        foundOrder.setQuantity(quantity);
        foundOrder.setProduct(productRepository.findById(productId).orElseThrow(()-> new IllegalArgumentException("해당 상품이 존재하지 않음")));
        orderRepository.save(foundOrder);
    }

    @Override
    public void cancelOrder(Long orderId) {
        if(orderRepository.existsById(orderId)){
            //주문 취소한 수량만큼 상품 재고 증가
            Order deleteOrder = orderRepository.findById(orderId).get();
            Product updateProduct = productRepository.findById(deleteOrder.getProduct().getId()).orElseThrow(()->new IllegalArgumentException("해당 상품 없음"));
            Integer increaseStock = deleteOrder.getQuantity() + updateProduct.getStock();
            updateProduct.setStock(increaseStock);
            productRepository.save(updateProduct);

            orderRepository.deleteById(orderId);
        }else{
            throw new IllegalArgumentException("해당 주문이 존재하지 않음");
        }
    }
}