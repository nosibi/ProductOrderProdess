package com.OrderProcess.dao;

import com.OrderProcess.data.Grade;
import com.OrderProcess.data.entity.Member;

public interface MemberDAO {
    //회원 정보 등록
    void saveMember(Member member);

    //회원 이름 수정
    void updateMemberName(Long id,String name);

    //회원 등급 수정
    void updateMemberGrade(Long id, Grade grade);

    //회원 조회
    Member findMember(Long id);

    //회원 삭제
    void deleteMember(Long id);
}