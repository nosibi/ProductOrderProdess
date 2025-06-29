package com.OrderProcess.repository.impl;

import com.OrderProcess.data.entity.Order;
import com.OrderProcess.data.entity.QOrder;
import com.OrderProcess.repository.OrderRepositoryCustom;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class OrderRepositoryCustomImpl implements OrderRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Order> findOrderListByName(String memberName) {
        JPAQuery<Order> query = new JPAQuery<>(entityManager);
        QOrder qOrder = QOrder.order;
        return query.from(qOrder).where(qOrder.member.name.eq(memberName)).fetch();
    }
}