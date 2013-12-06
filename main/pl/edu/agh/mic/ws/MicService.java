package pl.edu.agh.mic.ws;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import org.apache.commons.codec.binary.Base64;
import org.ektorp.Attachment;
import org.ektorp.AttachmentInputStream;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.Options;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;

import pl.edu.agh.mic.model.Decision;
import pl.edu.agh.mic.model.Ticket;
import pl.edu.agh.mic.model.TicketRepository;

@WebService(targetNamespace = "http://ws.mic.agh.edu.pl/", endpointInterface = "pl.edu.agh.mic.ws.MicServiceSEI", portName = "MicServicePort", serviceName = "MicServiceService")
public class MicService implements MicServiceSEI {

	@Override
	public String addTicket(String description, String createdBy) {
		TicketRepository repo = repository();
		Ticket ticket = new Ticket(createdBy, currentDate());
		ticket.setDescription(description);
		repo.add(ticket);
		return ticket.getId();
	}

	@Override
	public boolean takeOwnership(String ticketId, String userId) {
		try {
			TicketRepository repo = repository();
			Ticket ticket = repo.get(ticketId);
			ticket.setOwnerId(userId);
			repo.update(ticket);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	

	@Override
	public boolean addDecission(String ticketId, String type, String decidedBy) {
		try {
			TicketRepository repo = repository();
			Ticket ticket = repo.get(ticketId);
			Decision decision = new Decision(decidedBy, type);
			ticket.setDecision(decision);
			repo.update(ticket);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean requestEval(String ticketId, String remarks) {
		try {
			TicketRepository repo = repository();
			Ticket ticket = repo.get(ticketId);
			Decision decision = ticket.getDecision();
			decision.setRemarks(remarks);
			repo.update(ticket);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean evalEta(String ticketId, Date time) {
		try {
			TicketRepository repo = repository();
			Ticket ticket = repo.get(ticketId);
			ticket.setEta(currentDate());
			repo.update(ticket);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean attachDoc(String ticketId, String name, String mime, String cotent) {
		try {
			TicketRepository repo = repository();
			Ticket ticket = repo.get(ticketId);
			Attachment attachement = new Attachment(name, cotent, mime);
			ticket.addInlineAttachment(attachement);
			repo.update(ticket);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public Ticket[] listTickets(String userId) {
		TicketRepository repo = repository();
		return toArray(repo.findOwnedBy(userId));
	}

	@Override
	public boolean deleteDoc(String ticketId, String name) {
		try {
			TicketRepository repo = repository();
			Ticket ticket = repo.get(ticketId);
			ticket.removeAttachment(name);
			repo.update(ticket);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public pl.edu.agh.mic.model.Attachment getAttachment(String ticketId, String name) {
		try {
			CouchDbConnector db = connect();
			AttachmentInputStream data = db.getAttachment(ticketId, name);
			byte[] array = new byte[(int)data.getContentLength()];
			data.read(array);
			String base64 = Base64.encodeBase64String(array);
			return new pl.edu.agh.mic.model.Attachment(ticketId, name,
					data.getContentType(), base64);
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public Ticket getTicket(String id) {
		try {
			TicketRepository repo = repository();
			Ticket ticket = repo.get(id);
			return addAttachmentNames(ticket);
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public Ticket[] getTickets(String userId) {
		TicketRepository repo = repository();
		return toArray(repo.findCreatedBy(userId));
	}

	@Override
	public Ticket[] getAllTickets() {
		TicketRepository repository = repository();
		return toArray(repository.getAll());
	}

	@Override
	public Ticket[] getTicketHistory(String id) {
		try {
			TicketRepository repo = repository();
			Options options = new Options().includeRevisions();
			Ticket latest = repo.get(id, options);
			List<String> revisions = latest.getRevisions().getIds();
			for(int i=0; i<revisions.size(); i++) {
				revisions.set(i, ""+(revisions.size()-i)+"-"+revisions.get(i));
			}
			Ticket[] history = new Ticket[revisions.size()];
			int i = 0;
			for(String rev : revisions) {
				Ticket revision = repo.get(id, new Options().revision(rev));
				history[i++] = addAttachmentNames(revision);
			}
			return history;
		}
		catch(Exception e) {
			return null;
		}
	}

	private String currentDate() {
		return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	}
	
	private Ticket[] toArray(List<Ticket> tickets) {
		Ticket[] array = new Ticket[tickets.size()];
		for(int i=0; i<tickets.size(); i++) {
			array[i] = addAttachmentNames(tickets.get(i));
		}
		return array;
	}
	
	private Ticket addAttachmentNames(Ticket t) {
		if(t.getAttachments() == null) {
			return t;
		}
		String[] names = new String[t.getAttachments().size()];
		int i = 0;
		for(String s : t.getAttachments().keySet()) {
			names[i++] = s;
		}
		t.setAttachmentNames(names);
		return t;
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
	
}
