package pl.edu.agh.mic.services;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.edu.agh.mic.services.TestCouch;
import pl.edu.agh.mic.services.TestCouchService;

public class TestCouchTest {

	@Test
	public void test() {
		TestCouchService service = new TestCouchService();
		String id = service.addCouch("Lukasz", "Brewczynski", "Deutschland");
		TestCouch couch = service.get(id);
		assertEquals("Lukasz", couch.getName());
		assertEquals("Brewczynski", couch.getSurname());
		assertEquals("Deutschland", couch.getCountry());
	}

}
