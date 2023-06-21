package kr.ac.kopo.biz.board;

public class BoardVO {

	private int postNo;
	private String writer;
	private String content;
	private String regDate;
	private String title;
	private int postPermission;
	private int hit;
	
	public int getPostNo() {
		return postNo;
	}
	
	public void setPostNo(int postNo) {
		this.postNo = postNo;
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
	
	public String getRegDate() {
		return regDate;
	}
	
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getPostPermission() {
		return postPermission;
	}
	
	public void setPostPermission(int postPermission) {
		this.postPermission = postPermission;
	}
	
	public int getHit() {
		return hit;
	}
	
	public void setHit(int hit) {
		this.hit = hit;
	}

	public BoardVO(int postNo, String writer, String content, String regDate, String title, int postPermission,
			int hit) {
		super();
		this.postNo = postNo;
		this.writer = writer;
		this.content = content;
		this.regDate = regDate;
		this.title = title;
		this.postPermission = postPermission;
		this.hit = hit;
	}

	public BoardVO() {
		super();
	}

	@Override
	public String toString() {
		return "BoardVO [postNo=" + postNo + ", writer=" + writer + ", content=" + content + ", regDate=" + regDate
				+ ", title=" + title + ", postPermission=" + postPermission + ", hit=" + hit + "]";
	}
	
	
}
