package com.ss.dao;

public class PageInfo {
	private Integer pageNo=1;     //当前第几页
	private Integer pageSize=5;   //每页多少条数据
	private Integer totalSize;    //数据总条数
	private Integer totalPage;    //总页数
	
	@Override
	public String toString() {
		return "PageInfo [pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalSize=" + totalSize + "]";
	}
	
	public PageInfo(Integer pageNo, Integer pageSize, Integer totalSize) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
		this.totalPage=totalSize%pageSize==0?totalSize/pageSize:totalSize/pageSize+1;
	}

	public PageInfo() {
		super();
	}

	public void front(){  //上一页
		--pageNo;
		if(pageNo<=0){
			pageNo=1;
		}
	}
	
	public void next(){   //下一页
		++pageNo;
		if(pageNo>totalPage){
			pageNo=totalPage;
		}
	}
	
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		if(pageNo<=0){
			pageNo=1;
		}else{
			this.pageNo = pageNo;
		}		
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		if(pageSize<=0){
			pageSize=5;
		}else{
			this.pageSize = pageSize;
		}
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
		this.totalPage=totalSize%pageSize==0?totalSize/pageSize:totalSize/pageSize+1;
	}	
}
