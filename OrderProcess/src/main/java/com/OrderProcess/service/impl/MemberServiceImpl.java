package com.OrderProcess.service.impl;

import com.OrderProcess.dao.MemberDAO;
import com.OrderProcess.data.Grade;
import com.OrderProcess.data.dto.MemberDTO;
import com.OrderProcess.data.entity.Member;
import com.OrderProcess.data.responseDTO.MemberResponseDTO;
import com.OrderProcess.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDAO memberDAO;

    @Override
    public void saveMember(MemberDTO member) {
        Member savedMember = new Member();
        savedMember.setName(member.getName());
        savedMember.setGrade(member.getGrade());
        memberDAO.saveMember(savedMember);
    }

    @Override
    public void updateMemberName(Long id, String name) {
        memberDAO.updateMemberName(id,name);
    }

    @Override
    public void updateMemberGrade(Long id, Grade grade) {
        memberDAO.updateMemberGrade(id,grade);
    }

    @Override
    public MemberResponseDTO findMember(Long id) {
        MemberResponseDTO memberResponseDTO = new MemberResponseDTO();
        Member member = memberDAO.findMember(id);

        memberResponseDTO.setId(member.getId());
        memberResponseDTO.setName(member.getName());
        memberResponseDTO.setGrade(member.getGrade());
        memberResponseDTO.setCreatedAt(member.getCreatedAt());
        memberResponseDTO.setUpdatedAt(member.getUpdatedAt());

        return memberResponseDTO;
    }

    @Override
    public void deleteMember(Long id) {
        memberDAO.deleteMember(id);
    }
}
