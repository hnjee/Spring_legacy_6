package com.hj.s6.notice;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.hj.s6.board.BoardService;
import com.hj.s6.board.BoardVO;
import com.hj.s6.board.file.BoardFileDAO;
import com.hj.s6.board.file.BoardFileVO;
import com.hj.s6.util.FileSaver;
import com.hj.s6.util.Pager;


@Service
public class NoticeService implements BoardService {
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private BoardFileDAO boardFileDAO;

	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
	
		long totalCount = noticeDAO.boardCount(pager);
		pager.makePage(totalCount);

		return noticeDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		noticeDAO.hitUpdate(num);
		return noticeDAO.boardSelect(num);
	}

	@Override
	public int boardWrite(BoardVO boardVO, MultipartFile[] files) throws Exception {
	// TODO Auto-generated method stub
		
		String path = servletContext.getRealPath("/resource/uploadNotice");
		System.out.println(path);
		
		//sequence 번호 받기
		boardVO.setNum(noticeDAO.boardNum());
		//notice table insert
		int result = noticeDAO.boardWrite(boardVO);
		
		for(MultipartFile file : files) {
			BoardFileVO boardFileVO = new BoardFileVO();
			String fileName = fileSaver.saveByTransfer(file, path);
			boardFileVO.setNum(boardVO.getNum());
			boardFileVO.setFileName(fileName);
			boardFileVO.setOriName(file.getOriginalFilename());
			boardFileVO.setBoard(1);
			boardFileDAO.fileInsert(boardFileVO);
		}
		return result;
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return noticeDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(long num) throws Exception {
		return noticeDAO.boardDelete(num);
	}
}
