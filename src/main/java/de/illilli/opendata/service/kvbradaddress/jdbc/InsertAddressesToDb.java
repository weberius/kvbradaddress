package de.illilli.opendata.service.kvbradaddress.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.io.IOUtils;
import org.postgis.PGgeometry;
import org.postgis.Point;

import de.illilli.jdbc.ConnectionFactory;
import de.illilli.opendata.service.kvbradaddress.NominatimResult;

public class InsertAddressesToDb {

	public static final int SRID = 4326;

	private int inserts;

	public int insert(List<NominatimResult> nominatimResultList) throws SQLException, IOException, NamingException {
		Connection conn = ConnectionFactory.getConnection();
		InputStream inputStream = this.getClass().getResourceAsStream("/insertAddressRecord.sql");
		String sql = IOUtils.toString(inputStream);

		QueryRunner run = new QueryRunner();
		// uid,name,bike,number
		for (NominatimResult bo : nominatimResultList) {
			Point point = new Point(bo.lat, bo.lon);
			point.setSrid(SRID);
			PGgeometry geom = new PGgeometry(point);

			inserts += run.update(conn, sql, bo.osmId, bo.address.houseNumber, bo.address.road,
					bo.address.neighbourhood, bo.address.suburb, bo.address.cityDistrict, bo.address.city,
					bo.address.county, bo.address.stateDistrict, bo.address.state, bo.address.postcode,
					bo.address.country, bo.address.countryCode, geom);
		}
		conn.close();

		return inserts;
	}

}
