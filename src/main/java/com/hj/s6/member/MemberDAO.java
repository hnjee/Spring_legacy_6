package com.hj.s6.member;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hj.s6.util.Pager;



@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.hj.s6.member.MemberDAO.";
	
	
	public long memberCount(Pager memberPager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memberCount", memberPager);
	}
	
	public List<MemberVO> memberList(Pager memberPager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"memberList", memberPager);
	}
	
	public MemberVO memberLogin(MemberVO memberVO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memberLogin", memberVO);
	}
	
	public int memberJoin(MemberVO memberVO) throws Exception{
		return sqlSession.insert(NAMESPACE+"memberJoin", memberVO);
	}
	
	public long memberIdCheck(String id) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memberIdCheck", id);
	}
	
}
