package com.hj.s6.qna;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hj.s6.board.BoardDAO;
import com.hj.s6.board.BoardVO;

@Repository
public class QnaDAO implements BoardDAO{
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.hj.s6.qna.QnaDAO.";

	@Override
	public long boardCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> boardList(Map<String, Integer> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(long num) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hitUpdate(long num) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
