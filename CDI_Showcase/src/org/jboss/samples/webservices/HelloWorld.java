package org.jboss.samples.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.8.redhat-7
 * 2013-11-22T16:40:41.516+01:00
 * Generated source version: 2.6.8.redhat-7
 * 
 */
@WebService(targetNamespace = "http://webservices.samples.jboss.org/", name = "HelloWorld")
@XmlSeeAlso({ObjectFactory.class})
public interface HelloWorld {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://webservices.samples.jboss.org/", className = "org.jboss.samples.webservices.SayHello")
    @WebMethod
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://webservices.samples.jboss.org/", className = "org.jboss.samples.webservices.SayHelloResponse")
    public java.lang.String sayHello(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "receivePDF", targetNamespace = "http://webservices.samples.jboss.org/", className = "org.jboss.samples.webservices.ReceivePDF")
    @WebMethod
    @ResponseWrapper(localName = "receivePDFResponse", targetNamespace = "http://webservices.samples.jboss.org/", className = "org.jboss.samples.webservices.ReceivePDFResponse")
    public java.lang.String receivePDF(
        @WebParam(name = "pdf", targetNamespace = "")
        byte[] pdf
    );
}