package pl.edu.agh.mic.model;

/**
 * Just an attachment...
 * 
 * @author filip
 *
 */
public class Attachment {
	
	private final String ticketId;
	private final String name;
	private final String mime;
	private final String content;
	
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

	public String getName() {
		return name;
	}

	public String getMime() {
		return mime;
	}

	public String getContent() {
		return content;
	}
	
}
