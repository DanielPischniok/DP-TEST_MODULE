/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author dpischniok
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlSite {
    
    @XmlAttribute(name = "name")
    private String name;
    
    @XmlElement(name = "documenttitle")
    private String documenttitle;
    
    @XmlElement(name = "description")
    private String description;
    
    @XmlElement(name = "keywords")
    private String keywords;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumenttitle() {
        return documenttitle;
    }

    public void setDocumenttitle(String documenttitle) {
        this.documenttitle = documenttitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    
    
}
