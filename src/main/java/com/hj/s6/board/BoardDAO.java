package com.hj.s6.board;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
	//인터페이스
	//멤버변수(상수)와 추상메서드만 가질 수 있음 
	// 1) 모든 멤버변수는 public static final이어야 하며, 이를 생략할 수 있다.
	// 2) 모든 메서드는 public abstract이어야 하며, 이를 생략할 수 있다.
	
	//Count
	public long boardCount() throws Exception;
	
	//List 
	public abstract List<BoardVO> boardList(Map<String, Integer> map) throws Exception;
	
	//Select 
	public abstract BoardVO boardSelect(long num) throws Exception;
	
	//Insert
	public abstract int boardWrite(BoardVO boardVO) throws Exception;	
	
	//Delete
	public int boardDelete(long num) throws Exception;
	
	//Update
	public int boardUpdate(BoardVO boardVO) throws Exception;
	
	//HitUpdate
	public int hitUpdate(long num) throws Exception;
}
