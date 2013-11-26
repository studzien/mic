package pl.edu.agh.mic.model;


/**
 * Ticket represents one, unique record received from insurance company.
 * 
 * @author filip
 * 
 */
public class Ticket {

	private final String id;

	private final String createdBy;

	private final String createdDate;

	private String status;

	private String decissionId;

	private String eta;

	private String ownerId;

	private String description;
	
	public Ticket() {
		this(null, null, null);
	}

	public Ticket(String id, String createdBy, String createdDate) {
		super();
		this.id = id;
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

	public String getId() {
		return id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}
	
}
