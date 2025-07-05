package com.OrderProcess.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_table")
@Setter
@Getter
@NoArgsConstructor
public class Order extends BasedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer cost;

    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false)
    private String memberName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private String productName;
}