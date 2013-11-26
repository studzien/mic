package pl.edu.agh.mic.ws;

import java.util.Date;

import javax.jws.WebService;

import pl.edu.agh.mic.model.Ticket;

@WebService(
        portName = "MicPort",
        serviceName = "MicService",
        targetNamespace = "http://mic.agh.edu.pl/wsdl",
        endpointInterface = "pl.edu.agh.mic.ws.MicService")
public class MicService implements MicServiceWs {

	@Override
	public String addTicket(String description, String createdBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean takeOwnership(String ticketId, String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addDecission(String ticketId, String type, String decidedBy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean requestEval(String ticketId, String remarks) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean evalEta(String ticketId, Date time) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean attachDoc(String ticketId, String document) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Ticket[] listTickets(String userId) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
