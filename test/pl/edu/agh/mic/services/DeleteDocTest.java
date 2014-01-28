package pl.edu.agh.mic.services;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pl.edu.agh.mic.ws.MicService;

public class DeleteDocTest {
	
	private MicService service; 
	private String ticket_id;
	
	@Before
	public void setUp(){
		service = new MicService();
		ticket_id = service.addTicket("test ticket#1", "mp");
		service.attachDoc(ticket_id, "attachment#1", "text/plain", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
	}
	
	@Test
	public void deleteDocTest() {		
		boolean result = service.deleteDoc(ticket_id, "attachment#1");
		assertTrue("cannot delete doc", result);
	}
	
	@Test
	public void deleteNonExistentDocTest() {		
		boolean result = service.deleteDoc(ticket_id, "attachment#2");
		assertFalse("shouldnt delete non-existent doc", result);
		// fail!
	}
	
	@Test
	public void deleteDocNonExistentTicketTest() {		
		boolean result = service.deleteDoc(ticket_id + "sthWrong", "attachment#1");
		assertFalse("shouldnt delete doc from  non-existent ticket", result);
	}
	
	@After
	public void tearDown() {
		service.deleteTicket(ticket_id);	
	}
}
