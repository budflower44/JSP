package handler;

import domain.PagingVO;

public class PagingHandler {
	//list 하단에 나오는 페이지네이션 핸들링 클래스
	private int startPage; //현재 화면에서 보여줄 시작 페이지네이션 번호
	private int endPage; //현재 화면에서 보여줄 끝 페이지네이션 번호
	private int realEndPage; //실제 전체 리스트의 끝 번호
	private boolean prev, next; //이전, 다음페이지 존재여부
	
	//파라미터로 받기
	private int totalCount; //전체 글 수
	private PagingVO pgvo; //PageNo, pty => 현재 사용자가 클릭한 번호화 한 화면에 표시되는 개수
	
	//생성자에서 다 처리하기
	public PagingHandler(PagingVO pgvo, int totalCount) {
		this.pgvo = pgvo; // 1, 10
		//컨트롤러에서 DB에서 조회 후 파라미터로 전송 
		this.totalCount = totalCount;
		// 1/10 => 0.1 => (올림) 1 => 1*10 => 10
		// 2/10 => 0.2 => (올림) 1 => 1*10 => 10
		this.endPage = (int)Math.ceil(pgvo.getPageNo() / (double)pgvo.getQty()) * pgvo.getQty();
		this.startPage = this.endPage -9;
		
		//전체 게시글 수 / 한 화면에 게시되는 게시글 수 
		// 101 / 10 -> 10.1 -> (올림) -> 11페이지
		this.realEndPage = (int)Math.ceil(totalCount / (double)pgvo.getQty());
		
		//realEndPage != endPage 일때 처리
		if(this.realEndPage < this.endPage) {
			this.endPage = this.realEndPage;
		}
		
		//이전, 다음 유무
		this.prev = this.startPage > 1;
		this.next = this.endPage < this.realEndPage;
		
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getRealEndPage() {
		return realEndPage;
	}

	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public PagingVO getPgvo() {
		return pgvo;
	}

	public void setPgvo(PagingVO pgvo) {
		this.pgvo = pgvo;
	}

	@Override
	public String toString() {
		return "PagingHandler [StartPage=" + startPage + ", endPage=" + endPage + ", realEndPage=" + realEndPage
				+ ", prev=" + prev + ", next=" + next + ", totalCount=" + totalCount + ", pgvo=" + pgvo + "]";
	}
	
	
	
	
	
}
