package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlTransient;

public class Message {
	private long id;
	private String message;
	private String author;
	private Map<Long, Comments> comments=new HashMap<>();
	private List<Link> links = new ArrayList<>();
	
	public Message(){	
	}
	
	public Message(long i, String string, String string2) {
		id=i;
		message=string;
		author=string2;
	}
	public Long getId() {
		return id;
	}
	public void setId(long messageId) {
		this.id = messageId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@XmlTransient
	public Map<Long, Comments> getComments() {
		return comments;
	}
	public void setComments(Map<Long, Comments> comments) {
		this.comments = comments;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	public void addLink(String url, String rel){
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}
}