package com.hj.s6.memo;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hj.s6.util.Pager;

@Service
public class MemoService {
	@Autowired
	private MemoDAO memoDAO;
	
	public List<MemoVO> memoList(Pager pager) throws Exception{
		pager.makeRow();
	
		return memoDAO.memoList(pager);
	}
	
	public int memoWrite(MemoVO memoVO) throws Exception{
		return memoDAO.memoWrite(memoVO);
	}
}
