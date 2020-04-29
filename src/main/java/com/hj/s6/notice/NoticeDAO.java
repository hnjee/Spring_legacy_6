package com.hj.s6.notice;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.hj.s6.board.BoardDAO;
import com.hj.s6.board.BoardVO;
import com.hj.s6.util.Pager;


@Repository
public class NoticeDAO implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.hj.s6.notice.NoticeDAO.";
	
	public long boardNum() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"boardNum");
	}
	
	@Override
	public long boardCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"boardCount", pager);
	}
		
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"boardList", pager);	//알아서 리스트로 
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"boardSelect", num); //하나만 
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		return sqlSession.insert(NAMESPACE+"boardWrite", boardVO);
	}
	
	@Override
	public int boardDelete(long num) throws Exception {
		return sqlSession.delete(NAMESPACE+"boardDelete", num);
	}
	
	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return sqlSession.update(NAMESPACE+"boardUpdate", boardVO);
	}
	
	@Override
	public int hitUpdate(long num) throws Exception {
		return sqlSession.update(NAMESPACE+"hitUpdate", num);
	}
}