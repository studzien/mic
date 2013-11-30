package pl.edu.agh.mic.ws;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.ektorp.Attachment;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;

import pl.edu.agh.mic.model.Decision;
import pl.edu.agh.mic.model.Ticket;
import pl.edu.agh.mic.model.TicketRepository;

@WebService(targetNamespace = "http://ws.mic.agh.edu.pl/", portName = "MicServicePort", serviceName = "MicServiceService", endpointInterface = "pl.edu.agh.mic.ws.MicServiceSEI")
public class MicService implements MicServiceSEI {

	@Override
	public String addTicket(String description, String createdBy) {
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		Ticket ticket = new Ticket(createdBy, date);
		ticket.setDescription(description);
		CouchDbConnector db = connect();
		db.create(ticket);
		return ticket.getId();
	}

	@Override
	public boolean takeOwnership(String ticketId, String userId) {
		try {
			CouchDbConnector db = connect();
			Ticket ticket = db.get(Ticket.class, ticketId);
			ticket.setOwnerId(userId);
			db.update(ticket);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	

	@Override
	public boolean addDecission(String ticketId, String type, String decidedBy) {
		try {
			CouchDbConnector db = connect();
			Ticket ticket = db.get(Ticket.class, ticketId);
			Decision decision = new Decision(decidedBy, type);
			db.create(decision);
			ticket.setDecision(decision);
			db.update(ticket);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean requestEval(String ticketId, String remarks) {
		try {
			CouchDbConnector db = connect();
			Ticket ticket = db.get(Ticket.class, ticketId);
			Decision decision = db.get(Decision.class, ticket.getDecision().getId());
			decision.setRemarks(remarks);
			db.update(decision);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean evalEta(String ticketId, Date time) {
		try {
			CouchDbConnector db = connect();
			Ticket ticket = db.get(Ticket.class, ticketId);
			String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			ticket.setEta(date);
			db.update(ticket);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean attachDoc(String ticketId, String name, String mime, String cotent) {
		try {
			CouchDbConnector db = connect();
			Ticket ticket = db.get(Ticket.class, ticketId);
			Attachment attachement = new Attachment(name, cotent, mime);
			ticket.addInlineAttachment(attachement);
			db.update(ticket);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public Ticket[] listTickets(String userId) {
		TicketRepository repository = repository();
		List<Ticket> tickets = repository.getAll();
		Ticket[] array = new Ticket[tickets.size()];
		for(int i=0; i<tickets.size(); i++) {
			Ticket t = tickets.get(i);
			Map<String, Attachment> attachments = t.getAttachments();
			if(attachments != null) {
				for(String s : attachments.keySet()) {
					t.removeAttachment(s);
				}
			}
			array[i] = t;
		}
		return array;
	}

	private CouchDbConnector connect() {
		HttpClient httpClient = new StdHttpClient.Builder().build();
		CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
		CouchDbConnector db = dbInstance.createConnector("mic_db", true);
		return db;
	}
	
	private TicketRepository repository() {
		CouchDbConnector db = connect();
		return new TicketRepository(db);
	}

	@Override
	public boolean deleteDoc(String ticketId, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Attachment getAttachment(String ticketId, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket getTicket(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket[] getTickets(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket[] getAllTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket[] getTicketHistory(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
