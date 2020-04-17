package com.hj.s6.qna;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.hj.s6.board.BoardService;
import com.hj.s6.board.BoardVO;

public class QnaService implements BoardService{
	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public List<BoardVO> boardList(int curPage) throws Exception {
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
	public int boardUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(long num) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
