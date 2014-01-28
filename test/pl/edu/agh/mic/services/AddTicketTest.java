package pl.edu.agh.mic.services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pl.edu.agh.mic.ws.MicService;

public class AddTicketTest {
	
	private MicService service; 
	
	@Before
	public void setUp(){
		service = new MicService();
	}
	
	@Test
	public void addTicketTest() {
		String ticket_id = service.addTicket("test ticket#1", "mp");
		assertTrue("id must be 32 chars long", ticket_id.length() == 32);
	}
}
