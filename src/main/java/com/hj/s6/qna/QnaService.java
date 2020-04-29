package com.hj.s6.qna;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hj.s6.board.BoardService;
import com.hj.s6.board.BoardVO;
import com.hj.s6.util.Pager;

@Service
public class QnaService implements BoardService{
	@Autowired
	private QnaDAO qnaDAO;
	
	public int boardReply(BoardVO boardVO) throws Exception{
		int res = qnaDAO.boardReplyUpdate(boardVO);
		res = qnaDAO.boardReply(boardVO);
		return res;
	}
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(qnaDAO.boardCount(pager));
		return qnaDAO.boardList(pager);
	}

	@Override
	public int boardWrite(BoardVO boardVO, MultipartFile[] files) throws Exception {
		return qnaDAO.boardWrite(boardVO);
	}
	
	@Override
	public BoardVO boardSelect(long num) throws Exception {
		qnaDAO.hitUpdate(num);
		return qnaDAO.boardSelect(num);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return qnaDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(long num) throws Exception {
		return qnaDAO.boardDelete(num);
	}
}
