package de.illilli.opendata.service.kvbradaddress;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class AskForBikesListDependsOnModtime extends AskForBikes {

	public AskForBikesListDependsOnModtime(long lastrun) throws MalformedURLException, IOException {
		String urlString = url + "?lastrun=" + lastrun;
		this.inputStream = new URL(urlString).openStream();
	}

	public AskForBikesListDependsOnModtime(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
