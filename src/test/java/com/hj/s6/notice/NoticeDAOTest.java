package com.hj.s6.notice;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hj.s6.AbstractTestCase;

public class NoticeDAOTest extends AbstractTestCase {
	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
//	public void daoIsnull() {
//		assertNotNull(noticeDAO);
//	}
	
//	@Test
//	public void boardWriteTest()throws Exception {
//		NoticeVO noticeVO = new NoticeVO();
//		noticeVO.setTitle("test title");
//		noticeVO.setWriter("test writer");
//		noticeVO.setContents("test contents");
//		int result = noticeDAO.boardWrite(noticeVO);
//		assertEquals(1, result);
//	}
	
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
	
	@Test
	public void hitUpdate() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setHit(0);
		noticeVO.setNum(4);
		int result = noticeDAO.hitUpdate(noticeVO);
		assertEquals(1, result);
	}
}
