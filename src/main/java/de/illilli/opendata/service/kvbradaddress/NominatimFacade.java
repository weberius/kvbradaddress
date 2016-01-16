package de.illilli.opendata.service.kvbradaddress;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class NominatimFacade {

	public static final String FORMAT = "json";
	private List<NominatimResult> nominatimResultList;

	public NominatimFacade() {
		nominatimResultList = new ArrayList<NominatimResult>();
	}

	public List<NominatimResult> getList(List<BikeBo> bikesList) throws MalformedURLException, IOException {
		for (BikeBo bikeBo : bikesList) {
			AskForGeoCodingNominatim askFor = new AskForGeoCodingNominatim(NominatimFacade.FORMAT, bikeBo.getLat(),
					bikeBo.getLng());
			NominatimResult result = askFor.getNominatimResult();
			nominatimResultList.add(result);
		}
		return nominatimResultList;
	}
}
