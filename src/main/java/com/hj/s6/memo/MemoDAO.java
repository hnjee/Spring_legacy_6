package com.hj.s6.memo;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hj.s6.util.Pager;

@Repository
public class MemoDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.hj.s6.memo.MemoDAO.";
	
	public List<MemoVO> memoList(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"memoList", pager);
	}
	
	public int memoWrite(MemoVO memoVO) throws Exception{
		return sqlSession.insert(NAMESPACE+"memoWrite", memoVO);
	}
}
