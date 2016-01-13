package de.illilli.opendata.service.kvbradaddress;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

import de.illilli.opendata.service.DbWriter;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.kvbradaddress.jdbc.InsertLastRunToDb;
import de.illilli.opendata.service.kvbradaddress.jdbc.SelectLastrunFromDb;

public class PutAddressFacade implements Facade {

	private static final Logger logger = Logger.getLogger(PutAddressFacade.class);

	private long lastrun;
	private AskForBikes askForBikes;
	private DbWriter lastRunWriter;

	public PutAddressFacade() throws SQLException, NamingException, IOException {
		// letzten Lauf ermitteln
		this.lastrun = new SelectLastrunFromDb().getTime();
		logger.info("lastrun: '" + new Date(this.lastrun).toString() + "'");
		// lese alle Änderungen nach dem letzten Lauf
		this.askForBikes = new AskForBikesMapDependsOnModtime(lastrun);
		Map<Integer, List<BikeBo>> bikesMap = this.askForBikes.getBikesMap();
		// ermittle für alle Punkte die Adresse
		List<Address> addressList = new NominatimFacade().getList(bikesMap);
		// schreibe das Ergebnis in die Datenbank
		int numberOfInserts = new InsertAddressesToDb().insert(addressList);
		// vermerken, dass Daten geschrieben wurde
		this.lastRunWriter = new InsertLastRunToDb(numberOfInserts);

	}

	@Override
	public String getJson() throws JsonProcessingException {
		// TODO Auto-generated method stub
		return null;
	}

}
