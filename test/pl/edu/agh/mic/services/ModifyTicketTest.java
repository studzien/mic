package pl.edu.agh.mic.services;

import static org.junit.Assert.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pl.edu.agh.mic.model.Decision;
import pl.edu.agh.mic.model.Ticket;
import pl.edu.agh.mic.ws.MicService;

public class ModifyTicketTest {
	
	private static String[] ticket_ids = new String[10];
	private static MicService service;

	@BeforeClass
    public static void oneTimeSetUp() {
		ModifyTicketTest.service = new MicService();	
		ticket_ids[0] = ModifyTicketTest.service.addTicket("test ticket modify#1", "mp");
		ticket_ids[1] = ModifyTicketTest.service.addTicket("test ticket modify#2", "mp");
		ticket_ids[2] = ModifyTicketTest.service.addTicket("test ticket modify#3", "mp");
	}	
	
	@Test 
	public void addDecisonTest(){
		String owner = "fd";
		String type = "positive";
		boolean result = ModifyTicketTest.service.addDecission(ticket_ids[0], type, owner);
		assertTrue("cannot add decision", result);
		
		Ticket ticket = ModifyTicketTest.service.getTicket(ticket_ids[0]);
		assertEquals(ticket.getDecision().getDecidedBy(), owner);				
		assertEquals(ticket.getDecision().getType(), type);
	}	

	@Test
	public void getNonExistentDecsionTest() {		
		Ticket ticket = ModifyTicketTest.service.getTicket(ticket_ids[2]);
		Decision decision;
		try {
			decision = ticket.getDecision();
		} catch(Exception e){
			decision = null;
		}
		assertEquals(decision, null);		
	}
	
	@Test
	public void takeOwnershipTest() {
		String owner = "rs";
		boolean result = ModifyTicketTest.service.takeOwnership(ticket_ids[0], owner);
		assertTrue("cannot take ownership for ticket", result);
		
		Ticket ticket = ModifyTicketTest.service.getTicket(ticket_ids[0]);
		assertEquals(ticket.getOwnerId(), owner);		
	}	

	@Test
	public void requestEvalTest() {
		String remarks = "some remarks#1";
		ModifyTicketTest.service.addDecission(ticket_ids[1], "type", "lb");
		
		boolean result = ModifyTicketTest.service.requestEval(ticket_ids[1], remarks);
		assertTrue("cannot add remarks", result);
		
		Ticket ticket = ModifyTicketTest.service.getTicket(ticket_ids[1]);
		assertEquals(ticket.getDecision().getRemarks(), remarks);		
	}

	@Test
	public void requestNonExistentEvalTest() {		
		Ticket ticket = ModifyTicketTest.service.getTicket(ticket_ids[2]);
		String remarks;
		try {
			remarks = ticket.getDecision().getRemarks();
		} catch(Exception e){
			remarks = null;
		}
		assertEquals(remarks, null);		
	}
	
	@Test
	public void evalEtaTest() {
		Ticket ticket = ModifyTicketTest.service.getTicket(ticket_ids[0]);
		assertFalse("ticket does not exist", ticket == null);
		
		long DAY = 1000 * 60 * 60 * 24;  
		Date now = new Date();  
        long later = now.getTime() + (160 * DAY);  
        Date then = new Date(later);  
        
        boolean result = ModifyTicketTest.service.evalEta(ticket_ids[0], then);
		assertTrue("cannot set eval eta date", result);
		
		ticket = ModifyTicketTest.service.getTicket(ticket_ids[0]);		
		String then_str = new SimpleDateFormat("dd-MM-yyyy").format(then);
		assertEquals(ticket.getEta(), then_str);
		// fail!
	}
	
	@Test 
	public void deleteNonExistentTicketTest() throws NoSuchAlgorithmException{
		// create random ID
		MessageDigest sha = MessageDigest.getInstance("SHA-1");
		sha.update(Float.toString((float) (Math.random()*100)).getBytes());
		byte[] msgDigest = sha.digest();		
		
		boolean result = ModifyTicketTest.service.deleteTicket(msgDigest.toString());
		assertFalse("deleted ticket which does not exist", result);
	}
	
	@AfterClass
    public static void oneTimeTearDown() {
		for(String id : ticket_ids) {
			ModifyTicketTest.service.deleteTicket(id);
		}
    }

}
