
package pl.edu.agh.mic.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.6.11
 * Sat Nov 30 00:51:26 CET 2013
 * Generated source version: 2.6.11
 */

@XmlRootElement(name = "addDecissionResponse", namespace = "http://ws.mic.agh.edu.pl/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addDecissionResponse", namespace = "http://ws.mic.agh.edu.pl/")

public class AddDecissionResponse {

    @XmlElement(name = "return")
    private boolean _return;

    public boolean getReturn() {
        return this._return;
    }

    public void setReturn(boolean new_return)  {
        this._return = new_return;
    }

}

