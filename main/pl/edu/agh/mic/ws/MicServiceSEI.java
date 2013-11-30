package pl.edu.agh.mic.ws;

import java.util.Date;

import javax.jws.WebService;

import org.ektorp.Attachment;

import pl.edu.agh.mic.model.Ticket;

@WebService(name = "MicServiceSEI", targetNamespace = "http://ws.mic.agh.edu.pl/")
public interface MicServiceSEI {
	
	public String addTicket(String description, String createdBy);
	
	public boolean takeOwnership(String ticketId, String userId);
	
	public boolean addDecission(String ticketId, String type, String decidedBy);
	
	public boolean requestEval(String ticketId, String remarks);
	
	public boolean evalEta(String ticketId, Date time);
	
	public boolean attachDoc(String ticketId, String name, String mime, String cotent);
	
	public boolean deleteDoc(String ticketId, String name);
	
	public Attachment getAttachment(String ticketId, String name);
	
	public Ticket[] listTickets(String userId);
	
	public Ticket getTicket(String id);
	
	public Ticket[] getTickets(String userId);
	
	public Ticket[] getAllTickets();
	
	public Ticket[] getTicketHistory(String id);

}
