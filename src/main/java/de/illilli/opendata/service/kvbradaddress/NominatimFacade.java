package de.illilli.opendata.service.kvbradaddress;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class NominatimFacade {

	public static final String FORMAT = "json";
	private List<Address> addressList;

	public NominatimFacade() {
		addressList = new ArrayList<Address>();
	}

	public List<Address> getList(List<BikeBo> bikesList) throws MalformedURLException, IOException {
		for (BikeBo bikeBo : bikesList) {
			AskForGeoCodingNominatim askFor = new AskForGeoCodingNominatim(NominatimFacade.FORMAT, bikeBo.getLat(),
					bikeBo.getLng());
			NominatimResult result = askFor.getNominatimResult();
			addressList.add(result.address);
		}
		return addressList;
	}
}
