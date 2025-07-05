package com.OrderProcess.data.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    //주문 수량은 양수여야 함
    @Positive
    private Integer quantity;

    //회원번호는 0부터 시작
    @Min(value = 0)
    private Long MemberId;

    //상품번호는 0부터 시작
    @Min(value = 0)
    private Long ProductId;
}
