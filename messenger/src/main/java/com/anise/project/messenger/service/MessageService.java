package com.anise.project.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.anise.project.messenger.database.DatabaseClass;
import com.anise.project.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		messages.put(1l,new Message(1,"Anise", "Anise"));
		messages.put(2l,new Message(2,"Helllo", "Anise"));
	}
	
	public List<Message> getAllMessage(){
		
		return new ArrayList<Message>(messages.values()); 
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId()<=0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		 return messages.remove(id);
	}
}
