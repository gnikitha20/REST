package resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import service.CommentsService;
import model.Comments;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentsResource {
	CommentsService cs = new CommentsService();
	
	@GET
	public List<Comments> getComments(@PathParam("messageId") long messageId){
		return cs.getAllComments(messageId); 
				}
	@GET
	@Path("/{commentId}")
	public Comments test(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId){
		return cs.getComments(messageId,commentId);	
	}
	@PUT
	@Path("/{commentId}")
	public Comments test2(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId,Comments comments){
			return cs.updateComments(messageId,comments);
		}
		
	@POST
	@Path("/{commentId}")
	public Comments test3(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId,Comments comments){
		comments.setCommentId(commentId);
		return cs.addComments(messageId,comments);
	}
	@DELETE
	@Path("/{commentId}")
	public Comments test4(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId){
		return cs.removeComments(messageId,commentId);
	}
	
}
