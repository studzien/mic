package pl.edu.agh.mic.model;

import java.util.List;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.View;
import org.ektorp.support.Views;

@Views({
	@View(name = "all", map = "function(doc) { if(doc.model === 'Ticket') emit(null, doc) }"),
	@View(name = "created_by", map = "function(doc) { if(doc.model === 'Ticket') emit(doc.createdBy, doc) }"),
	@View(name = "owned_by", map = "function(doc) { if(doc.model === 'Ticket') emit(doc.ownerId, doc) }")
})
public class TicketRepository extends CouchDbRepositorySupport<Ticket> {

	public TicketRepository(CouchDbConnector db) {
		super(Ticket.class, db);
		initStandardDesignDocument();
	}
	
	public List<Ticket> findCreatedBy(String id) {
		return queryView("created_by", id);
	}
	
	public List<Ticket> findOwnedBy(String id) {
		return queryView("owned_by", id);
	}
}
