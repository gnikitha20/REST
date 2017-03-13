package service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import database.DatabaseClass;
import model.Message;
public class MessageService {

	private Map<Long, Message> messages=DatabaseClass.getMessages();
	public MessageService(){
		messages.put(1L, new Message(1,"First Message","Pranay"));
		messages.put(2L, new Message(2,"Second Message","Pranay"));
		messages.put(3L, new Message(3,"Third Message","Pranay"));
	}
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
		}
	public Message getMessage(long id){
		return messages.get(id);
		}
    public Message addMessage(Message message){
		if(message.getId()<=0){
			return null;
		}
		messages.put(message.getId(),message);
		return message;
		}
    public Message updateMessage(Message message){
    	if(message.getId()<=0){
			return null;
    	}
		messages.put(message.getId(),message);
		return message;
    	}
    public Message removeMessage(long id){
    	return messages.remove(id);
    }
}
