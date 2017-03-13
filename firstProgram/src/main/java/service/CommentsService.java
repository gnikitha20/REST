package service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Comments;
import model.Message;
import database.DatabaseClass;
public class CommentsService {

	private Map<Long, Message> messages=DatabaseClass.getMessages();
	public CommentsService(){
	}
	public List<Comments> getAllComments(long messageId){
		Map<Long,Comments> comments=messages.get(messageId).getComments();
		return new ArrayList<Comments>(comments.values());
		}
	public Comments getComments(long messageId,long commentId){
		Map<Long,Comments> comments=messages.get(messageId).getComments();
		return comments.get(commentId);
		}
    public Comments addComments(long messageId,Comments comment){
		Map<Long,Comments> comments=messages.get(messageId).getComments();	
		comment.setCommentId(comments.size()+1);
		comments.put(comment.getCommentId(),comment);
 		return comment;
		}
    public Comments updateComments(long messageId,Comments comment){
		Map<Long,Comments> comments=messages.get(messageId).getComments();
		comments.put(comment.getCommentId(),comment);
		return comment;
    	}
    public Comments removeComments(long messageId,long commentId){
		Map<Long,Comments> comments=messages.get(messageId).getComments();
    	return comments.remove(commentId);
    	}
}