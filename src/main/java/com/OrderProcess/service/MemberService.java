package com.OrderProcess.service;

import com.OrderProcess.data.Grade;
import com.OrderProcess.data.dto.MemberDTO;
import com.OrderProcess.data.responseDTO.MemberResponseDTO;

import java.util.List;

public interface MemberService {
    //회원 정보 등록
    void saveMember(MemberDTO member);

    //회원 이름 수정
    void updateMemberName(Long id,String name);

    //회원 등급 수정
    void updateMemberGrade(Long id, Grade grade);

    //회원 조회
    MemberResponseDTO findMember(Long id);

    //회원 리스트 조회
    List<MemberResponseDTO> findMemberList(String name);

    //회원 삭제
    void deleteMember(Long id);
}
