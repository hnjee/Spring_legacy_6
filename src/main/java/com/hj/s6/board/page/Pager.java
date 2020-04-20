package com.hj.s6.board.page;

public class Pager {
	private Long curPage; //현재 페이지
	private Integer perPage;  //한 페이지 당 게시물 수 
	
	private long startRow;
	private long lastRow;
	
	private long totalPage;
	private long totalBlock;
	private long curBlock;
	
	private long startNum;
	private long lastNum;	
	
	private String kind;
	private String search;

	public void makeRow() {
		this.startRow = (this.getCurPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getCurPage()*this.getPerPage();
	}
	
	public void makePage(long totalCount) {
		//1. totalCount : 전체 글의 개수
		
		//2. totalCount로 totalPage 계산 
		this.totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage()!=0) {
			this.totalPage++;
		}
		
		//3. totalPage로 totalBlock 계산
		long perBlock = 5L; //한 block당 Page수 
		this.totalBlock = totalPage/perBlock;
		if(totalPage % perBlock != 0) {
			this.totalBlock++;
		}
		
		//4. curPage를 가지고 curBlock 찾기 
		this.curBlock = this.curPage/perBlock;
		if(this.curPage%perBlock!=0) {
			this.curBlock++;
		}
		
		//5. curBlock으로 startNum, lastNum 계산 
		this.startNum = (this.curBlock-1)*perBlock+1;
		this.lastNum = this.curBlock * perBlock;
		
		//5-2. 마지막 페이지인 경우 
		if(this.curBlock==this.totalBlock) {
			this.lastNum=this.totalPage;
		}
		
		//6. 검색 결과가 없을 경우 
		if(totalCount==0) {
			this.startNum=1;
			this.lastNum=1;
		}
	}
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public long getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(long totalBlock) {
		this.totalBlock = totalBlock;
	}

	public long getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(long curBlock) {
		this.curBlock = curBlock;
	}

	public long getStartNum() {
		return startNum;
	}

	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}

	public long getLastNum() {
		return lastNum;
	}

	public void setLastNum(long lastNum) {
		this.lastNum = lastNum;
	}

	public void setStartRow(long startRow) {
		this.startRow = startRow;
	}

	public void setLastRow(long lastRow) {
		this.lastRow = lastRow;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public long getStartRow() {
		return startRow;
	}

	public long getLastRow() {
		return lastRow;
	}

	public Long getCurPage() {
		if(this.curPage == null||this.curPage==0) {
			this.curPage=1L;
		}
		return curPage;
	}
	public void setCurPage(Long curPage) {
		this.curPage = curPage;
	}
	public Integer getPerPage() {
		if(this.perPage==null||this.perPage==0) {
			this.perPage=10;
		}
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}

}
