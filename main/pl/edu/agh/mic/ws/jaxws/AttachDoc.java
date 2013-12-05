
package pl.edu.agh.mic.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.7.8
 * Thu Dec 05 18:57:00 CET 2013
 * Generated source version: 2.7.8
 */

@XmlRootElement(name = "attachDoc", namespace = "http://ws.mic.agh.edu.pl/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attachDoc", namespace = "http://ws.mic.agh.edu.pl/", propOrder = {"ticketId", "name", "mime", "content"})

public class AttachDoc {

    @XmlElement(name = "ticketId", required = true)
    private java.lang.String ticketId;
    @XmlElement(name = "name", required = true)
    private java.lang.String name;
    @XmlElement(name = "mime", required = true)
    private java.lang.String mime;
    @XmlElement(name = "content", required = true)
    private java.lang.String content;

    public java.lang.String getTicketId() {
        return this.ticketId;
    }

    public void setTicketId(java.lang.String newTicketId)  {
        this.ticketId = newTicketId;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String newName)  {
        this.name = newName;
    }

    public java.lang.String getMime() {
        return this.mime;
    }

    public void setMime(java.lang.String newMime)  {
        this.mime = newMime;
    }

    public java.lang.String getContent() {
        return this.content;
    }

    public void setContent(java.lang.String newContent)  {
        this.content = newContent;
    }

}

