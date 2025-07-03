package com.OrderProcess.data.dto;

import com.OrderProcess.data.Grade;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {
    private String name;
    private Grade grade;
}
