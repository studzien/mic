package pl.edu.agh.mic.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.TypeDiscriminator;

/**
 * Remarks for the ticket made by workshop
 * 
 * @author filip
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@TypeDiscriminator("doc.model === 'Decision'")
public class Decision extends CouchDbDocument {
	
	private static final long serialVersionUID = 1L;
	
	private final String decidedBy;
	
	private final String type;
	
	private String remarks;
	
	private final String model = "Decision";
	
	public Decision() {
		this(null, null);
	}

	public Decision(String decidedBy, String type) {
		super();
		this.decidedBy = decidedBy;
		this.type = type;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDecidedBy() {
		return decidedBy;
	}

	public String getType() {
		return type;
	}

	public String getModel() {
		return model;
	}
	
}
