package pl.edu.agh.mic.model;

/**
 * Just an attachment...
 * 
 * @author filip
 *
 */
public class Attachment {
	
	private String ticketId;
	private String name;
	private String mime;
	private String content;
	
	public Attachment() {
		this(null, null, null, null);
	}

	public Attachment(String ticketId, String name, String mime, String content) {
		super();
		this.ticketId = ticketId;
		this.name = name;
		this.mime = mime;
		this.content = content;
	}

	public String getTicketId() {
		return ticketId;
	}
	
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getMime() {
		return mime;
	}
	
	public void setMime(String mime) {
		this.mime = mime;
	}

	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
}
