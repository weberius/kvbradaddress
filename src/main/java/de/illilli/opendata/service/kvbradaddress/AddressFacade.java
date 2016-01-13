package de.illilli.opendata.service.kvbradaddress;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import de.illilli.opendata.service.Facade;

public class AddressFacade implements Facade {

	private Address address = new Address();

	public AddressFacade(Double x, Double y) {

	}

	@Override
	public String getJson() throws JsonProcessingException {
		Gson gson = new Gson();
		return gson.toJson(address);
	}

}
