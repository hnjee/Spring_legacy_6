package com.hj.s6.notice;



import java.util.List;

import com.hj.s6.board.BoardVO;
import com.hj.s6.board.file.BoardFileVO;

public class NoticeVO extends BoardVO{
	private List<BoardFileVO> boardFileVOs;

	public List<BoardFileVO> getBoardFileVOs() {
		return boardFileVOs;
	}

	public void setBoardFileVOs(List<BoardFileVO> boardFileVOs) {
		this.boardFileVOs = boardFileVOs;
	}
}
