package de.viada.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import de.viada.qualifier.ApplicationLogger;

@ManagedBean(name="myBean")
@ViewScoped
public class JSFBean implements Serializable{
	
	
	@Inject
	@ApplicationLogger
	Logger log;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String test;
	
	@PostConstruct
	public void init(){
		test = ""+System.currentTimeMillis();
		log.info("test");
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	
}
