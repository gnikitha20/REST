package database;

import java.util.HashMap;
import java.util.Map;

import model.Comments;
import model.Message;
import model.Profile;

public class DatabaseClass {
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	private static Map<Long, Comments> comments = new HashMap<>();

	public static Map<Long, Message> getMessages(){
		return messages;
	}	
	public static Map<String, Profile> getProfile() {
		return profiles;
	}
	public static Map<Long, Comments> getComments() {
		return comments;
	}

}
