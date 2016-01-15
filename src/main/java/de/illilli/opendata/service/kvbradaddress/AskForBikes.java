package de.illilli.opendata.service.kvbradaddress;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import de.illilli.opendata.service.Config;

/**
 * Diese Klasse ist die Schnittstelle für alle AskForBikes Implementierungen und
 * erwartet einen Stream. Die hier implementierte Methode getBikesMap() wandelt
 * die Struktur in eine Map-Struktur.
 */
public abstract class AskForBikes {

	String url = Config.getProperty("kvblive.bikeslist.url");
	InputStream inputStream;

	/**
	 * Diese Methode übernimmt die per InputStream gelieferten Bikes und wandelt
	 * sie mit Hilfe von Gson in ein Map<Integer, List<BikeBo>> Object.
	 * 
	 * @return
	 * @throws IOException
	 */
	public List<BikeBo> getBikesList() throws IOException {
		Gson gson = new Gson();
		Type type = new TypeToken<List<BikeBo>>() {
		}.getType();
		String json = IOUtils.toString(inputStream);
		List<BikeBo> bikesMap = gson.fromJson(json, type);
		if (bikesMap == null) {
			bikesMap = new ArrayList<BikeBo>();
		}
		return bikesMap;
	}
}
