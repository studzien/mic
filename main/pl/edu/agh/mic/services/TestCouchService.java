package pl.edu.agh.mic.services;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;

public class TestCouchService {
	public String addCouch(String name, String surname, String country) {
		CouchDbConnector db = connect();
		TestCouch couch = new TestCouch();
		couch.setName(name);
		couch.setSurname(surname);
		couch.setCountry(country);
		db.create(couch);
		return couch.getId();
	}
	
	public TestCouch get(String id) {
		CouchDbConnector db = connect();
		TestCouch couch = db.get(TestCouch.class, id);
		return couch;
	}
	
	private CouchDbConnector connect() {
		HttpClient httpClient = new StdHttpClient.Builder().build();
		CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
		CouchDbConnector db = dbInstance.createConnector("dummy_database", true);
		return db;
	}
}
