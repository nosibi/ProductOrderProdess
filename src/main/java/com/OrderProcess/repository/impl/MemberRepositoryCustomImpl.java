package com.OrderProcess.repository.impl;

import com.OrderProcess.data.entity.Member;
import com.OrderProcess.data.entity.QMember;
import com.OrderProcess.repository.MemberRepositoryCustom;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Member> getMemberListByName(String name) {
        JPAQuery<Member> query = new JPAQuery<>(entityManager);
        QMember qMember = QMember.member;
        return query.from(qMember).where(qMember.name.eq(name)).orderBy(qMember.createdAt.asc()).fetch();
    }
}
