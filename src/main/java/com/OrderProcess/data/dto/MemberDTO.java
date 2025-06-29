package com.OrderProcess.data.dto;

import com.OrderProcess.configuration.annotation.Name;
import com.OrderProcess.data.Grade;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {

    //커스텀 validation으로 유효성 검사

    //회원 이름은 2자 이상 9자 이하
    @Name
    private String name;

    //GOLD,SILVER,BRONZE 등급 외에는 입력 불허
    @com.OrderProcess.configuration.annotation.Grade
    private Grade grade;
}
