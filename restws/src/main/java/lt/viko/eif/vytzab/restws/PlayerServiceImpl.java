package lt.viko.eif.vytzab.restws;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import lt.viko.eif.vytzab.restws.model.Player;
import lt.viko.eif.vytzab.restws.model.Record;

@Service
public class PlayerServiceImpl implements PlayerService {
	private static Map<BigInteger, Player> league = new HashMap<BigInteger, Player>();
	BigInteger currentId = BigInteger.valueOf(1);

	public PlayerServiceImpl() {
		init();
	}

	public void init() {
		Player player = new Player();
		Record record = new Record();

		record.setGamesplayed(BigInteger.valueOf(30));
		record.setWins(BigInteger.valueOf(20));
		record.setLosses(BigInteger.valueOf(10));

		player.setId(currentId);
		player.setFirstName("Vytautas");
		player.setLastName("Zabielskas");
		player.setAge("29");
		player.setHeight("180cm");
		player.setWeight("80kg");
		player.setNationality("Lithuanian");
		player.setStatus("Active");
		player.setRecord(record);

		league.put(player.getId(), player);
	}

	@Override
	public List<Player> getPlayers() {
		Collection<Player> players = league.values();
		List<Player> response = new ArrayList<>(players);

		return response;
	}

	@Override
	public Player getPlayer(BigInteger id) {
		return league.get(id);
	}

	@Override
	public Response createPlayer(Player player) {
		currentId = currentId.add(BigInteger.valueOf(1));
		player.setId(currentId);
		league.put(player.getId(), player);

		return Response.ok(player).build();
	}

	@Override
	public Response updatePlayer(Player player) {
		Player currentPlayer = league.get(player.getId());
		Response response;

		if (currentPlayer != null) {
			league.put(player.getId(), player);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}

		return response;
	}

	@Override
	public Response deletePlayer(BigInteger id) {
		Player player = league.get(id);
		Response response;

		if (player != null) {
			league.remove(id);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}

		return response;
	}
}
