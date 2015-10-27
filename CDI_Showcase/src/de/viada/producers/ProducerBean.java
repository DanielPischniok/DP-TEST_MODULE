package de.viada.producers;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Singleton;

import org.jboss.logging.Logger;

import de.viada.qualifier.ApplicationLogger;
import de.viada.qualifier.HelloWorld;

@Singleton
public class ProducerBean {
	
	@Produces @ApplicationLogger
	public Logger produceLogger(InjectionPoint ip){
		return Logger.getLogger(ip.getMember().getDeclaringClass());
	}
	
	@Produces
	@HelloWorld
	private String helloString = "Injected Hello World!";

}
