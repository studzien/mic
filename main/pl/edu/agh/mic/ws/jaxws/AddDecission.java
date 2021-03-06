
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

@XmlRootElement(name = "addDecission", namespace = "http://ws.mic.agh.edu.pl/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addDecission", namespace = "http://ws.mic.agh.edu.pl/", propOrder = {"ticketId", "type", "decidedBy"})

public class AddDecission {

    @XmlElement(name = "ticketId", required = true)
    private java.lang.String ticketId;
    @XmlElement(name = "type", required = true)
    private java.lang.String type;
    @XmlElement(name = "decidedBy", required = true)
    private java.lang.String decidedBy;

    public java.lang.String getTicketId() {
        return this.ticketId;
    }

    public void setTicketId(java.lang.String newTicketId)  {
        this.ticketId = newTicketId;
    }

    public java.lang.String getType() {
        return this.type;
    }

    public void setType(java.lang.String newType)  {
        this.type = newType;
    }

    public java.lang.String getDecidedBy() {
        return this.decidedBy;
    }

    public void setDecidedBy(java.lang.String newDecidedBy)  {
        this.decidedBy = newDecidedBy;
    }

}

