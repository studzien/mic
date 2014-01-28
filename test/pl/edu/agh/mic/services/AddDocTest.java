package pl.edu.agh.mic.services;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.commons.codec.binary.Base64;
import pl.edu.agh.mic.ws.MicService;

public class AddDocTest {
	
	private MicService service; 
	private String ticket_id;
	
	@Before
	public void setUp() {
		service = new MicService();
		ticket_id = service.addTicket("test ticket#1", "mp");
	}
	
	@Test
	public void attachDocTest(){
		byte[] encodedBytes = Base64.encodeBase64("Test".getBytes());
		boolean result = service.attachDoc(ticket_id, "attachment_1", "text/plain", new String(encodedBytes));
		assertTrue("cannot add attachment", result);
	}
	
	@Test
	public void attachDocNonExistentTicketTest(){
		byte[] encodedBytes = Base64.encodeBase64("Test".getBytes());
		boolean result = service.attachDoc(ticket_id + "somethingWrong", "attachment#1", "text/plain", new String(encodedBytes));
		assertFalse("shouldnt add attachment to non-existent ticket", result);
	}
	
	
	@After
	public void tearDown() {
		service.deleteTicket(ticket_id);
	}
}
