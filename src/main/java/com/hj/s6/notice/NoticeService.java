package com.hj.s6.notice;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		//NoticeVO 
		//1. sequence 번호 받아서 num에 세팅 
		boardVO.setNum(noticeDAO.boardNum());
		//2. NoticeVO DB에 저장 
		int result = noticeDAO.boardWrite(boardVO);
	
		//file
		//1. 파일 path 가져오기 
		String path = servletContext.getRealPath("/resources/uploadnotice");
		System.out.println(path);
	
		for(MultipartFile file : files) {
			if(file.getSize()>0) {
				//2. 파일을 HDD에 저장 
				String fileName = fileSaver.saveByTransfer(file, path); 
				
				//3. boardFileVO 생성, 세팅 
				BoardFileVO boardFileVO = new BoardFileVO();
				boardFileVO.setNum(boardVO.getNum());
				boardFileVO.setFileName(fileName);
				boardFileVO.setOriName(file.getOriginalFilename());
				boardFileVO.setBoard(1);
				boardFileDAO.fileInsert(boardFileVO); //파일VO DB에 저장
			}
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
