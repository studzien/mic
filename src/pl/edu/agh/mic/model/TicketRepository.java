package pl.edu.agh.mic.model;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.View;
import org.ektorp.support.Views;

@Views({
	@View(name = "all", map = "function(doc) { if(doc.model === 'Ticket') emit(null, doc) }")
})
public class TicketRepository extends CouchDbRepositorySupport<Ticket> {

	public TicketRepository(CouchDbConnector db) {
		super(Ticket.class, db);
		initStandardDesignDocument();
	}

}
