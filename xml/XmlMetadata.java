/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.xml;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dpischniok
 */
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlMetadata {
    
    @XmlElement(name = "site")
    private List<XmlSite> sites;

    public List<XmlSite> getSites() {
        return sites;
    }

    public void setSites(List<XmlSite> sites) {
        this.sites = sites;
    }
    
}
