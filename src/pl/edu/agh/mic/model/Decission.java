package pl.edu.agh.mic.model;

/**
 * Remarks for the ticket made by workshop
 * 
 * @author filip
 *
 */
public class Decission {
	
	private final String id;
	
	private final String decidedBy;
	
	private final String type;
	
	private String remarks;
	
	public Decission() {
		this(null, null, null);
	}

	public Decission(String id, String decidedBy, String type) {
		super();
		this.id = id;
		this.decidedBy = decidedBy;
		this.type = type;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getId() {
		return id;
	}

	public String getDecidedBy() {
		return decidedBy;
	}

	public String getType() {
		return type;
	}
	
}
