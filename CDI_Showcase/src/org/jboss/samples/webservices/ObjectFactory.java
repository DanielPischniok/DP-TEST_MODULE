
package org.jboss.samples.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.jboss.samples.webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SayHello_QNAME = new QName("http://webservices.samples.jboss.org/", "sayHello");
    private final static QName _SayHelloResponse_QNAME = new QName("http://webservices.samples.jboss.org/", "sayHelloResponse");
    private final static QName _ReceivePDF_QNAME = new QName("http://webservices.samples.jboss.org/", "receivePDF");
    private final static QName _ReceivePDFResponse_QNAME = new QName("http://webservices.samples.jboss.org/", "receivePDFResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.jboss.samples.webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayHelloResponse }
     * 
     */
    public SayHelloResponse createSayHelloResponse() {
        return new SayHelloResponse();
    }

    /**
     * Create an instance of {@link SayHello }
     * 
     */
    public SayHello createSayHello() {
        return new SayHello();
    }

    /**
     * Create an instance of {@link ReceivePDFResponse }
     * 
     */
    public ReceivePDFResponse createReceivePDFResponse() {
        return new ReceivePDFResponse();
    }

    /**
     * Create an instance of {@link ReceivePDF }
     * 
     */
    public ReceivePDF createReceivePDF() {
        return new ReceivePDF();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.samples.jboss.org/", name = "sayHello")
    public JAXBElement<SayHello> createSayHello(SayHello value) {
        return new JAXBElement<SayHello>(_SayHello_QNAME, SayHello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.samples.jboss.org/", name = "sayHelloResponse")
    public JAXBElement<SayHelloResponse> createSayHelloResponse(SayHelloResponse value) {
        return new JAXBElement<SayHelloResponse>(_SayHelloResponse_QNAME, SayHelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReceivePDF }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.samples.jboss.org/", name = "receivePDF")
    public JAXBElement<ReceivePDF> createReceivePDF(ReceivePDF value) {
        return new JAXBElement<ReceivePDF>(_ReceivePDF_QNAME, ReceivePDF.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReceivePDFResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.samples.jboss.org/", name = "receivePDFResponse")
    public JAXBElement<ReceivePDFResponse> createReceivePDFResponse(ReceivePDFResponse value) {
        return new JAXBElement<ReceivePDFResponse>(_ReceivePDFResponse_QNAME, ReceivePDFResponse.class, null, value);
    }

}
