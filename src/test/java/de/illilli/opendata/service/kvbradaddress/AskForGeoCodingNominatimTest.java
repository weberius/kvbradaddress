package de.illilli.opendata.service.kvbradaddress;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Before;

public class AskForGeoCodingNominatimTest {

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws MalformedURLException, IOException {
		String format = "json";
		double lat = 50.94022903;
		double lon = 6.975675467;

		AskForGeoCodingNominatim askFor = new AskForGeoCodingNominatim(format, lat, lon);
		NominatimResult result = askFor.getNominatimResult();
		System.out.println(result.toString());
	}

}
