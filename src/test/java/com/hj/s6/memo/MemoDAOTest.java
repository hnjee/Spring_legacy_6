package com.hj.s6.memo;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hj.s6.AbstractTestCase;

public class MemoDAOTest extends AbstractTestCase{
	@Autowired
	private MemoDAO memoDAO;
	
	@Test
	public void test() throws Exception {
		for(int i=0; i<100; i++) {
			MemoVO memoVO = new MemoVO();
			memoVO.setWriter("writer "+i);
			memoVO.setContents("contents "+i);
			memoDAO.memoWrite(memoVO);
		}
	}
}
