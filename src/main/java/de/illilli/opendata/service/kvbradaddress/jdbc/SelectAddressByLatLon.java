package de.illilli.opendata.service.kvbradaddress.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.io.IOUtils;
import org.postgis.PGgeometry;
import org.postgis.Point;

import de.illilli.jdbc.ConnectionFactory;

public class SelectAddressByLatLon {

	String queryString = "/selectAddressByLatLon.sql";
	private AddressFromDb address;
	private Connection conn;
	private String sql;
	private PGgeometry geom;
	public static final int SRID = 4326;

	public SelectAddressByLatLon(double lat, double lng) throws SQLException, NamingException, IOException {
		Point point = new Point(lat, lng);
		point.setSrid(SRID);
		geom = new PGgeometry(point);
		conn = ConnectionFactory.getConnection();
		InputStream inputStream = this.getClass().getResourceAsStream(queryString);
		sql = IOUtils.toString(inputStream);
	}

	public AddressFromDb getAddress() throws SQLException {
		QueryRunner query = new QueryRunner();
		ResultSetHandler<AddressFromDb> handler = new BeanHandler<AddressFromDb>(AddressFromDb.class);
		Object[] params = new Object[] { geom };
		address = query.query(conn, sql, handler, params);
		conn.close();
		return address;
	}

}
