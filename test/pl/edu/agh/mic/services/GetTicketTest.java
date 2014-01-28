package pl.edu.agh.mic.services;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pl.edu.agh.mic.model.Ticket;
import pl.edu.agh.mic.ws.MicService;

public class GetTicketTest {
	
	private static String[] ticket_ids = new String[10];
	private static MicService service;

	@BeforeClass
    public static void oneTimeSetUp() {
		GetTicketTest.service = new MicService();	
		ticket_ids[0] = GetTicketTest.service.addTicket("test ticket modify#1", "mp");
		ticket_ids[1] = GetTicketTest.service.addTicket("test ticket modify#2", "mp");
	}	

	@Test
	public void getTicketTest() {
		Ticket ticket = GetTicketTest.service.getTicket(ticket_ids[0]);
		assertTrue("variable is not an instance of Ticket", ticket instanceof Ticket);
	}
		
	@Test 
	public void getTicketHistoryTest(){
		Ticket[] history = GetTicketTest.service.getTicketHistory(ticket_ids[0]);
		assertTrue("history of ticket is empty", history.length > 0);
		
	}
	
	@Test 
	public void getAllTicketsTest(){
		Ticket[] tickets = GetTicketTest.service.getAllTickets();
		
		int length = tickets.length;
		assertTrue("there should be some tickets in the array", length > 0);
		
		ticket_ids[2] = GetTicketTest.service.addTicket("test ticket modify#3", "mp");
		tickets = GetTicketTest.service.getAllTickets();
		assertEquals((length + 1), tickets.length);
	}

	@AfterClass
    public static void oneTimeTearDown() {
		for(String id : ticket_ids) {
			GetTicketTest.service.deleteTicket(id);
		}
    }

}

	