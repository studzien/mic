package pl.edu.agh.mic.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.ektorp.Attachment;
import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.TypeDiscriminator;


/**
 * Ticket represents one, unique record received from insurance company.
 * 
 * @author filip
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@TypeDiscriminator("doc.model === 'Ticket'")
public class Ticket extends CouchDbDocument {

	private static final long serialVersionUID = 1L;

	private final String createdBy;

	private final String createdDate;

	private String status;

	private String decissionId;

	private String eta;

	private String ownerId;

	private String description;
	
	private final String model = "Ticket";
	
	public Ticket() {
		this(null, null);
	}

	public Ticket(String createdBy, String createdDate) {
		super();
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDecissionId() {
		return decissionId;
	}

	public void setDecissionId(String decissionId) {
		this.decissionId = decissionId;
	}

	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public String getModel() {
		return model;
	}

	@Override
	@JsonIgnore
	public void addInlineAttachment(Attachment a) {
		super.addInlineAttachment(a);
	}

	@Override
	@JsonIgnore
	public void removeAttachment(String id) {
		super.removeAttachment(id);
	}

}
