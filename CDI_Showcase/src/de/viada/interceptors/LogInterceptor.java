package de.viada.interceptors;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.jboss.logging.Logger;

import de.viada.qualifier.ApplicationLogger;

@Interceptor
@Logged
public class LogInterceptor implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Inject
	@ApplicationLogger
	Logger log;


	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		log.info("Interceptor Ausgabe before");
		Object value = ic.proceed();
		log.info("Interceptor Ausgabe after");
		return value;
	}

}
