
package pl.edu.agh.mic.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.6.11
 * Sun Jan 19 11:17:23 CET 2014
 * Generated source version: 2.6.11
 */

@XmlRootElement(name = "deleteTicketResponse", namespace = "http://ws.mic.agh.edu.pl/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteTicketResponse", namespace = "http://ws.mic.agh.edu.pl/")

public class DeleteTicketResponse {

    @XmlElement(name = "return")
    private boolean _return;

    public boolean getReturn() {
        return this._return;
    }

    public void setReturn(boolean new_return)  {
        this._return = new_return;
    }

}

