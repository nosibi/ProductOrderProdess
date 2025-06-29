package com.OrderProcess.repository;

import com.OrderProcess.data.entity.Order;

import java.util.List;

public interface OrderRepositoryCustom {
    List<Order> findOrderListByName(String productName);
}
