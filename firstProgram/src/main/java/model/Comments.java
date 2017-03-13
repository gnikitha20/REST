package model;

public class Comments {
	private long commentId;
	private String creator;
	private String comment;
	public Comments(){
		
	}
	public Comments(long commentId, String creator,String comment) {
		super();
		// TODO Auto-generated constructor stub
		this.commentId=commentId;
		this.comment=comment;
		this.creator=creator;
	}
	public long getCommentId() {
		return commentId;
	}
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
