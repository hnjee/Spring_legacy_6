package com.hj.s6.member;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hj.s6.member.memberPager.MemberPager;


@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.hj.s6.member.MemberDAO.";
	
	
	public long MemberCount(MemberPager memberPager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memberCount", memberPager);
	}
	
	public List<MemberVO> MemberList(MemberPager memberPager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"memberList", memberPager);
	}
	
}
