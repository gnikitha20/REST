package resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import exception.DataNotFoundException;
import service.MessageService;
import model.Message;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
	MessageService ms = new MessageService();
	
	@GET
	public List<Message> getMessages(){
		return ms.getAllMessages();
	}
	@GET
	@Path("/{messageId}")
	public Message test(@PathParam("messageId") Long messageId, @Context UriInfo uriInfo){
		Message message = ms.getMessage(messageId);
		String link = null;
		if(message==null){
			throw new DataNotFoundException("Exception : message id "+messageId+" NOT FOUND");
		} else
			link = getUriInfoSelf(uriInfo, message);
			message.addLink(link,"self");
			link = getUriInfoProfile(uriInfo, message);
			message.addLink(link,"profile");
		return message;	
	}
	private String getUriInfoSelf(UriInfo uriInfo, Message message) {
		String link;
		link = uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(Long.toString(message.getId())).build().toString();
		return link;
	}
	private String getUriInfoProfile(UriInfo uriInfo, Message message) {
		String link;
		link = uriInfo.getBaseUriBuilder()
				.path(ProfileResource.class)
				.path(message.getAuthor()).build().toString();
		return link;
	}
	@PUT
	@Path("/{messageId}")
	public Message test2(@PathParam("messageId") long messageId,Message message){
			message.setId(messageId);
			return ms.updateMessage(message);
		}
		
	@POST
	@Path("/{messageId}")
	public Message test3(@PathParam("messageId") long messageId,Message message){
		message.setId(messageId);
		return ms.addMessage(message);
	}
	@DELETE
	@Path("/{messageId}")
	public Message test4(@PathParam("messageId") long messageId){
		return ms.removeMessage(messageId);
	}
	
	@Path("/{messageId}/comments")
	public CommentsResource getCommentsResource(){
		return new CommentsResource();
	}
	
}
