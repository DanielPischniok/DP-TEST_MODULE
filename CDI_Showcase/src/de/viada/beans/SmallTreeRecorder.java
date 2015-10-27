package de.viada.beans;

import java.io.Serializable;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import de.viada.events.TreeEvent;
import de.viada.qualifier.ApplicationLogger;
import de.viada.qualifier.SmallTreeEvent;
import de.viada.stereotypes.SessionBean;

@SessionBean
public class SmallTreeRecorder implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7994033783853101379L;
	
	@Inject
	@ApplicationLogger
	Logger log;
	
	public void record(@Observes @SmallTreeEvent TreeEvent e){
		log.info("Event Recorder!!! "+e.getEventText());
	}
	
	
}
