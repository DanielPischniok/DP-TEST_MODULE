package de.viada.trees;

import java.io.Serializable;

import javax.inject.Inject;

import org.jboss.logging.Logger;

import de.viada.qualifier.ApplicationLogger;
import de.viada.qualifier.SmallTree;

@SmallTree
public class Strauch implements Tree, Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@Inject
	@ApplicationLogger
	Logger log;

	@Override
	public void makeSomething() {
		log.info("Ich bin ein Strauch");

	}

}
