package pl.edu.agh.mic.services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pl.edu.agh.mic.ws.MicService;

public class DeleteTicketTest {
	
	private MicService service; 
	private String ticket_id;
	
	@Before
	public void setUp() {
		service = new MicService();
		ticket_id = service.addTicket("test ticket#1", "mp");
	}
	
	@Test
	public void deleteTicketTest() {
		boolean result = service.deleteTicket(ticket_id);
		assertTrue("cannot delete ticket", result);
	}
	
	@Test
	public void deleteNonExistentTicketTest() {
		boolean result = service.deleteTicket(ticket_id + "sthWrong");
		assertFalse("shouldnt delete non-existent ticket", result);
	}
}
