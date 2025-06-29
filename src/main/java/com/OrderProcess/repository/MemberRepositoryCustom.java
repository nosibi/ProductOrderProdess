package com.OrderProcess.repository;

import com.OrderProcess.data.entity.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> getMemberListByName(String name);
}
