package com.OrderProcess.data.responseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderResponseDTO {
    private Long id;
    private Integer quantity;
    private String memberName;
    private String productName;
    private Integer cost;
}
