package de.viada.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import de.viada.qualifier.ApplicationLogger;

@Named("convBean")
@ConversationScoped
public class ConversationBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int myValue;
	
	@Inject
	@ApplicationLogger
	Logger log;
	
	@Inject
	Conversation conversation;
	
	@PostConstruct
	public void init(){
		myValue = 42;
		log.info("Post Construct Conversation Bean");
	}
	
	@PreDestroy
	public void logDestroy(){
		log.info("Pre Destroy Conversation Bean");
	}
	
	public void start(){
		if(conversation.isTransient()){
			conversation.begin();
		}
	}
	
	public void end(){
		if(!conversation.isTransient()){
			conversation.end();
		}
	}

	public int getMyValue() {
		return myValue;
	}

	public void setMyValue(int myValue) {
		this.myValue = myValue;
	}
	

}
