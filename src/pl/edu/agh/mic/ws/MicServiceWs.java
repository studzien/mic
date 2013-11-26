package pl.edu.agh.mic.ws;

import java.util.Date;

import javax.jws.WebService;

import pl.edu.agh.mic.model.Ticket;

@WebService(targetNamespace = "http://mic.agh.edu.pl/wsdl")
public interface MicServiceWs {
	
	public String addTicket(String description, String createdBy);
	
	public boolean takeOwnership(String ticketId, String userId);
	
	public boolean addDecission(String ticketId, String type, String decidedBy);
	
	public boolean requestEval(String ticketId, String remarks);
	
	public boolean evalEta(String ticketId, Date time);
	
	public boolean attachDoc(String ticketId, String document);
	
	public Ticket[] listTickets(String userId);

}
