package com.hj.s6.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hj.s6.AbstractTestCase;
import com.hj.s6.board.BoardVO;

public class NoticeDAOTest extends AbstractTestCase {
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void daoTest()throws Exception{
		this.boardWriteTest();
	}
	
//	@Test
//	public void daoIsnull() {
//		assertNotNull(noticeDAO);
//	}
	
	public void boardWriteTest()throws Exception {
		int result=0;
		String writer = "";
		String title = "";
		String contents = "";
		
		for(int i=0; i<150; i++) {
			NoticeVO noticeVO = new NoticeVO();
			if(i%3==0) {
				writer="hj";
				title="hj Title";
				contents="hj Contents";
			} else if(i%3==1) {
				writer="jh";
				title="jh Title";
				contents="jh Contents";
			} else {
				writer="mk";
				title="mk Title";
				contents="mk Contents";
			}
			noticeVO.setTitle(title+" "+i);
			noticeVO.setWriter(writer);
			noticeVO.setContents(contents+" "+i);
			if(i==50||i==100) {
				Thread.sleep(1000);
			}
			result = noticeDAO.boardWrite(noticeVO);	
		}
	}
	
//	@Test
//	public void boardDelete() throws Exception{
//		int res = noticeDAO.boardDelete(3);
//		assertNotEquals(0, res);
//	}
	
//	@Test
//	public void boardUpdate() throws Exception{
//		NoticeVO noticeVO = new NoticeVO();
//		noticeVO.setTitle("변경된 제목");
//		noticeVO.setContents("변경된 내용");
//		noticeVO.setNum(2);
//		int result = noticeDAO.boardUpdate(noticeVO);
//		assertEquals(1, result);
//	}
	
//	@Test
//	public void hitUpdate() throws Exception{
//		NoticeVO noticeVO = new NoticeVO();
//		noticeVO.setHit(0);
//		noticeVO.setNum(4);
//		int result = noticeDAO.hitUpdate(noticeVO);
//		assertEquals(1, result);
//	}
	
//	@Test
//	public void boardSelectTest() throws Exception{
//		BoardVO boardVO = noticeDAO.boardSelect(2);
//		assertNotNull(boardVO);
//	}
	
//	@Test
//	public void boardListTest() throws Exception{
//		List<BoardVO> ar = noticeDAO.boardList();
//		assertNotEquals(0, ar.size());
//	}
}
