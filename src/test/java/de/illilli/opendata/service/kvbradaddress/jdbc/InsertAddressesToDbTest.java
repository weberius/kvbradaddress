package de.illilli.opendata.service.kvbradaddress.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.junit.Before;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import de.illilli.jdbc.JndiProperties;
import de.illilli.opendata.service.kvbradaddress.NominatimResult;

public class InsertAddressesToDbTest {

	private static final Logger logger = Logger.getLogger(InsertAddressesToDbTest.class);

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws IOException, SQLException, NamingException {
		JndiProperties.setUpConnectionForJndi();

		InputStream inputStream = InsertAddressesToDbTest.class.getResourceAsStream("/deutz.json");
		List<NominatimResult> nominatimResultList = new ArrayList<NominatimResult>();

		ObjectMapper mapper = new ObjectMapper();
		try {
			NominatimResult nominatimResult = mapper.readValue(inputStream, NominatimResult.class);
			nominatimResultList.add(nominatimResult);
		} catch (UnrecognizedPropertyException e) {
			logger.error(e);
		}
		inputStream.close();
		InsertAddressesToDb insert = new InsertAddressesToDb();
		int inserted = insert.insert(nominatimResultList);
		System.out.println("inserted = '" + inserted + "'");

	}

}
