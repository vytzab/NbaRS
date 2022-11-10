package lt.viko.eif.vytzab.restws;

import java.math.BigInteger;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import lt.viko.eif.vytzab.restws.model.Player;

@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
@Path("/playerservice")
public interface PlayerService {

	@Path("/players")
	@GET
	List<Player> getPlayers();

	@Path("/players/{id}")
	@GET
	Player getPlayer(@PathParam("id") BigInteger id);

	@Path("/players")
	@POST
	Response createPlayer(Player player);

	@Path("/players")
	@PUT
	Response updatePlayer(Player player);

	@Path("/players/{id}")
	@DELETE
	Response deletePlayer(@PathParam("id") BigInteger id);
}
