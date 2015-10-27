package de.viada.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import de.viada.events.TreeEvent;
import de.viada.qualifier.ApplicationLogger;
import de.viada.qualifier.SmallTreeEvent;
import de.viada.trees.Strauch;
import de.viada.trees.Tree;

@Decorator
public abstract class TreeDacorator implements Tree {

	@Inject
	@Delegate
	@Any
	private Tree tree;
	
	
	@Inject
	@SmallTreeEvent
	Event<TreeEvent> event;
	
	@Inject
	@ApplicationLogger
	Logger log;

	
	@Override
	public void makeSomething() {
		
		log.info("Decorator Ausgabe");
		
		if(tree instanceof Strauch){
			TreeEvent e = new TreeEvent();
			e.setEventText("Strauch Event");
			event.fire(e);
		}
		
		tree.makeSomething();
	}

}
