package de.viada.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;

import de.viada.qualifier.ApplicationLogger;
import de.viada.qualifier.BigTree;
import de.viada.qualifier.HelloWorld;
import de.viada.qualifier.SmallTree;
import de.viada.trees.Tree;

@Named
@ViewScoped
public class HelloCDIBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	@BigTree
	Tree tree;
	
	@Inject
	@SmallTree
	Tree tree2;
	
	@Inject
	@ApplicationLogger
	Logger log;
	
	@Inject
	@HelloWorld
	private String hello;
	
	@Inject
	private JSFBean jsfBean;
	
	@Inject
	private BeanManager bm;
	
	
	@PostConstruct
	public void init() throws NamingException{
		tree.makeSomething();
		tree2.makeSomething();
		log.info("JSF Bean "+jsfBean.getTest());
		log.info("JSF Bean "+System.identityHashCode(jsfBean));
		log.info("Application initialized");
		log.info(bm == null);
		
		bm = (BeanManager) new InitialContext().lookup("java:comp/BeanManager");
		log.info(bm.getContext(ConversationScoped.class).isActive());
		final Bean<?> bean = bm.resolve(bm.getBeans(Conversation.class));
		final CreationalContext<?> context = bm.createCreationalContext(bean);
		final Conversation c = (Conversation) bm.getReference(bean, Conversation.class, context);
		
		log.info(c);
		log.info(c.getId());
	}


	public Tree getTree() {
		return tree;
	}


	public void setTree(Tree tree) {
		this.tree = tree;
	}


	public Tree getTree2() {
		return tree2;
	}


	public void setTree2(Tree tree2) {
		this.tree2 = tree2;
	}


	public String getHello() {
		return hello;
	}


	public void setHello(String hello) {
		this.hello = hello;
	}
	
	
	
	



}
