package lt.viko.eif.vytzab.restws.services;

import java.util.List;

import lt.viko.eif.vytzab.restws.entities.Player;

/**
 * @author Vytautas
 *
 *         Interface to outline operations with <Player> objects.
 */
public interface IPlayerService {

	Player createPlayer(Player player);

	List<Player> getPlayers();

	Player getPlayerById(Long id);

	Player updatePlayer(Long id, Player player);

	void deletePlayerById(Long id);
}
