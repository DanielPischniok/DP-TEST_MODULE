/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.test.mbeans;

import java.io.InputStream;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import web.xml.XmlMetadata;
import web.xml.XmlSite;

/**
 *
 * @author dpischniok
 */
@Named(value = "xmlMetadataMB")
@ApplicationScoped
public class XmlMetadataMB {
    
    private XmlMetadata data;

    public XmlMetadataMB() {
    }

    @PostConstruct
    public void init() {
        String relPath = "/resources/xml/meta-data.xml";
        InputStream metaStream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(relPath);

        try {

            JAXBContext parser = JAXBContext.newInstance(XmlMetadata.class);
            Unmarshaller marshaller = parser.createUnmarshaller();
            data = (XmlMetadata) marshaller.unmarshal(metaStream);
            
            for(XmlSite site: data.getSites()){
                System.out.println(site.getName()+" "+site.getDescription());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String findKeywordsForName(String name){
        for(XmlSite site: data.getSites()){
            if(site.getName().equals(name)){
                return site.getKeywords();
            }
        }
        return "";
    }
    
    public String findDescriptionForName(String name){
        for(XmlSite site: data.getSites()){
            if(site.getName().equals(name)){
                return site.getDescription();
            }
        }
        return "";
    }
    
    public String findDocumenttitleForName(String name){
        for(XmlSite site: data.getSites()){
            if(site.getName().equals(name)){
                return site.getDocumenttitle();
            }
        }
        return "";
    }

}
