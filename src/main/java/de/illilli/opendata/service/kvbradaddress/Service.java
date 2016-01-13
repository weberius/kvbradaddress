package de.illilli.opendata.service.kvbradaddress;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opendata.service.Facade;

@Path("/")
public class Service {

	private final static Logger logger = Logger.getLogger(Service.class);

	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;

	/**
	 * <p>
	 * Dieser Service fragt neu hinzugekommene Geo-Punkte ab und ermittelt die
	 * dazu gehörenden Adressen. Die Ergebnisse werden dann in die Datenbank
	 * geschrieben.
	 * </p>
	 * <p>
	 * Beispiel:
	 * <code>curl -X PUT http://localhost:8080/kvbradaddress/service/put</code>
	 * </p>
	 * 
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 * @throws ClassNotFoundException
	 */
	@PUT
	@Path("/put")
	public void putAddress() throws JsonParseException, JsonMappingException, IOException, SQLException,
			NamingException, ClassNotFoundException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Facade facade = new PutAddressFacade();
	}

	/**
	 * 
	 * <p>
	 * Beispiel: <a href=
	 * "http://localhost:8080/kvbradanalysis/service/6.953765483/50.9639325">
	 * /kvbradanalysis/service/&lt;x&gt;/&lt;y&gt;</a>
	 * </p>
	 * 
	 * @param x
	 * @param y
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 * @throws ClassNotFoundException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{x}/{y}")
	public String getAddress(@PathParam("x") Double x, @PathParam("y") Double y) throws JsonParseException,
			JsonMappingException, IOException, SQLException, NamingException, ClassNotFoundException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Facade facade = new AddressFacade(x, y);
		return facade.getJson();
	}

}
