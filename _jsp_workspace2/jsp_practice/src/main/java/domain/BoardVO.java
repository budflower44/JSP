package domain;

public class BoardVO {
	/*   `bno` int NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `writer` varchar(100) NOT NULL,
  `content` text,
  `regdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `moddate` datetime DEFAULT CURRENT_TIMESTAMP,
  `readcount` int DEFAULT '0',
  PRIMARY KEY (`bno`)
	 * */
	
	private int bno;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private String moddate;
	private int readcount;
	private String imageFile;
	
	public BoardVO() {}
	
	//글쓰기(write) : title, writer, content
	public BoardVO(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	//글 수정(modify) : bno, title, content
	public BoardVO(int bno, String title, String content) {
		this.bno = bno;
		this.title = title;
		this.content = content;
	}
	//글 상세보기(detail) : bno, title, writer, moddate, readcount
	public BoardVO(int bno, String title, String writer, String moddate, int readcount) {
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.moddate = moddate;
		this.readcount = readcount;
	}
	//글 리스트 보기(list) : bno, title, writer, content, regdate, moddate, readcount
	public BoardVO(int bno, String title, String writer, String content, String regdate, 
			String moddate, int readcount, String imageFile) {
		this(bno, title, writer, moddate, readcount);
		this.content = content;
		this.regdate = regdate;
		this.imageFile = imageFile;
	}
	//글 삭제 : X
	
	//getter/setter
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getModdate() {
		return moddate;
	}

	public void setModdate(String moddate) {
		this.moddate = moddate;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + ", moddate=" + moddate + ", readcount=" + readcount + ", imageFile=" + imageFile + "]";
	}
	
	
	
	
}
