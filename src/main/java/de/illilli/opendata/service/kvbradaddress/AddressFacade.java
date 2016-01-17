package de.illilli.opendata.service.kvbradaddress;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.kvbradaddress.jdbc.AddressFromDb;
import de.illilli.opendata.service.kvbradaddress.jdbc.SelectAddressByLatLon;

public class AddressFacade implements Facade {

	private AddressForJson address;

	public AddressFacade(Double lat, Double lng) throws SQLException, NamingException, IOException {
		SelectAddressByLatLon select = new SelectAddressByLatLon(lat, lng);
		AddressFromDb addressFromDb = select.getAddress();
		address = new AddressForJson(addressFromDb, lat, lng);
	}

	@Override
	public String getJson() throws JsonProcessingException {
		Gson gson = new Gson();
		return gson.toJson(address);
	}

}
