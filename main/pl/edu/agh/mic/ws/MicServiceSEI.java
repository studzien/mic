package pl.edu.agh.mic.ws;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.ektorp.Attachment;

import pl.edu.agh.mic.model.Ticket;

@WebService(name = "MicServiceSEI", targetNamespace = "http://ws.mic.agh.edu.pl/")
public interface MicServiceSEI {
	
	@WebMethod(operationName = "addTicket", action = "urn:AddTicket")
	public String addTicket(@WebParam(name = "description") String description,
			 				@WebParam(name = "createdBy") String createdBy);
	
	@WebMethod(operationName = "takeOwnership", action = "urn:TakeOwnership")
	public boolean takeOwnership(@WebParam(name = "ticketId") String ticketId, @WebParam(name = "userId") String userId);
	
	@WebMethod(operationName = "addDecission", action = "urn:AddDecission")
	public boolean addDecission(@WebParam(name = "ticketId") String ticketId, @WebParam(name = "type") String type, @WebParam(name = "decidedBy") String decidedBy);
	
	@WebMethod(operationName = "requestEval", action = "urn:RequestEval")
	public boolean requestEval(@WebParam(name = "ticketId") String ticketId, @WebParam(name = "remarks") String remarks);
	
	@WebMethod(operationName = "evalEta", action = "urn:EvalEta")
	public boolean evalEta(@WebParam(name = "ticketId") String ticketId, @WebParam(name = "time") Date time);
	
	@WebMethod(operationName = "attachDoc", action = "urn:AttachDoc")
	public boolean attachDoc(@WebParam(name = "ticketId") String ticketId, @WebParam(name = "name") String name, @WebParam(name = "mime") String mime, @WebParam(name = "content") String cotent);
	
	@WebMethod(operationName = "deleteDoc", action = "urn:DeleteDoc")
	public boolean deleteDoc(@WebParam(name = "ticketId") String ticketId, @WebParam(name = "name") String name);
	
	@WebMethod(operationName = "getAttachment", action = "urn:GetAttachment")
	public Attachment getAttachment(@WebParam(name = "ticketId") String ticketId, @WebParam(name = "name") String name);
	
	@WebMethod(operationName = "listTickets", action = "urn:ListTickets")
	public Ticket[] listTickets(@WebParam(name = "decidedByUserId") String userId);
	
	@WebMethod(operationName = "getTicket", action = "urn:GetTicket")
	public Ticket getTicket(@WebParam(name = "ticketId") String id);
	
	@WebMethod(operationName = "getTickets", action = "urn:GetTickets")
	public Ticket[] getTickets(@WebParam(name = "createdByUserId") String userId);
	
	@WebMethod(operationName = "getAllTickets", action = "urn:GetAllTickets")
	public Ticket[] getAllTickets();
	
	@WebMethod(operationName = "getTicketHistory", action = "urn:GetTicketHistory")
	public Ticket[] getTicketHistory(@WebParam(name = "ticketId") String id);

}
