package com.OrderProcess.dao.impl;

import com.OrderProcess.dao.MemberDAO;
import com.OrderProcess.data.Grade;
import com.OrderProcess.data.entity.Member;
import com.OrderProcess.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDAOImpl implements MemberDAO {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void updateMemberName(Long id,String name){
        Member foundMember = memberRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 회원 없음"));
        foundMember.setName(name);
        memberRepository.save(foundMember);
    }

    @Override
    public void updateMemberGrade(Long id, Grade grade) {
        Member foundMember = memberRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 회원 없음"));
        foundMember.setGrade(grade);
        memberRepository.save(foundMember);
    }

    @Override
    public Member findMember(Long id) {
        return memberRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 회원 없음"));
    }

    @Override
    public void deleteMember(Long id) {
        if(memberRepository.findById(id).isPresent()){
            memberRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("해당 회원 없음");
        }
    }
}
