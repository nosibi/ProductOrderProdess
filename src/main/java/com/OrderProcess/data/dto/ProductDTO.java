package com.OrderProcess.data.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {

    //상품명을 공백으로 할 수 없음
    @NotBlank
    private String name;

    //상품 가격은 최소 100원 이상
    @Min(value = 100)
    private Integer price;

    //상품 재고는 양수만 허용
    @Positive
    private Integer stock;
}