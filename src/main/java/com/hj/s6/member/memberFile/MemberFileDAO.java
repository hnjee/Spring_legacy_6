package com.hj.s6.member.memberFile;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberFileDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.hj.s6.member.memberFile.MemberFileDAO.";
	
	
	//fileInsert
	public int fileInsert(MemberFileVO memberFileVO) throws Exception{
		return sqlSession.insert(NAMESPACE+"fileInsert", memberFileVO);
	}
	
	//fileDelete
	public int fileDelete(String id) throws Exception{

		return sqlSession.delete(NAMESPACE+"fileDelete", id);
	}
	
	//fileUpdate
	public int fileUpdate(MemberFileVO memberFileVO) throws Exception{
		return sqlSession.update(NAMESPACE+"fileUpdate", memberFileVO);
	}
	
	//fileSelect
	public MemberFileVO fileSelect(String id) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"fileSelect", id);
	}
}
