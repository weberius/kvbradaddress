package de.illilli.opendata.service.kvbradaddress.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.junit.Before;

import de.illilli.jdbc.JndiProperties;

public class SelectAddressByLatLonTest {

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws SQLException, NamingException, IOException {
		JndiProperties.setUpConnectionForJndi();

		double lat = 50.9303537;
		double lng = 7.00170505718218;
		SelectAddressByLatLon select = new SelectAddressByLatLon(lat, lng);
		AddressFromDb address = select.getAddress();
		System.out.println(address);
	}

}
