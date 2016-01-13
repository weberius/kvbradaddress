package de.illilli.opendata.service.kvbradaddress;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import de.illilli.opendata.service.Config;

/**
 * Abfrage des Nominatim-Service
 * <p>
 * Beispiel: <a href=
 * "http://nominatim.openstreetmap.org/reverse?format=json&lat=50.94022903&lon=6.975675467"
 * >http://nominatim.openstreetmap.org/reverse?format=json&lat=50.94022903&lon=6
 * .975675467</a>
 * </p>
 *
 */
public class AskForGeoCodingNominatim {

	private static final Logger logger = Logger.getLogger(AskForGeoCodingNominatim.class);
	private NominatimResult[] nominatimResult;
	String urlString = Config.getProperty("nominatim.url");

	public AskForGeoCodingNominatim(String format, double lat, double lon) throws MalformedURLException, IOException {
		urlString = "/reverse?format=" + format + "&json&lat=" + lat + "&lon=" + lon;
		URL url = new URL(urlString);

		InputStream inputStream = url.openStream();
		ObjectMapper mapper = new ObjectMapper();
		try {
			nominatimResult = mapper.readValue(inputStream, NominatimResult[].class);
		} catch (UnrecognizedPropertyException e) {
			logger.error(e);
		}
		inputStream.close();
	}

	/**
	 * Mit diesem Konstruktur kann das parsen der json-Struktur getestet werden.
	 * Über
	 * 
	 * <pre>
	 * InputStream inputStream = this.getClass().getResourceAsStream(&quot;/&lt;file&gt;.json&quot;);
	 * </pre>
	 * 
	 * wird eine in den resources abgelegte Datei eingelesen. Sie entspricht in
	 * ihrer Struktur der Antwort eines Nominatim Servers.
	 * 
	 * @param inputStream
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public AskForGeoCodingNominatim(InputStream inputStream)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		nominatimResult = mapper.readValue(inputStream, NominatimResult[].class);
		logger.debug(nominatimResult.toString());

	}

	public NominatimResult[] getNominatimResult() {
		return nominatimResult;
	}

}
