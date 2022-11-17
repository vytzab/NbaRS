package lt.viko.eif.vytzab.restws.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.viko.eif.vytzab.restws.entities.Player;
import lt.viko.eif.vytzab.restws.exceptions.ResourceNotFoundException;
import lt.viko.eif.vytzab.restws.repositories.IPlayerRepository;

/**
 * @author Vytautas
 *
 *         Class for the operations with <Player> objects implementation.
 */
@Service
public class PlayerServiceImpl implements IPlayerService {

	/**
	 * An instance of the <IPlayerRepository> in order to perform JPA operations on the
	 * in-memory database.
	 */
	@Autowired
	private IPlayerRepository playerRepo;

	/**
	 * Get a <Player> object from the database.
	 * 
	 * @param player <Player> object.
	 * @return a <Player> object.
	 */
	@Override
	public Player createPlayer(Player player) {
		return playerRepo.save(player);
	}

	/**
	 * Get all <Player> objects from the database.
	 * 
	 * @return a list of <Player> objects.
	 */
	@Override
	public List<Player> getPlayers() {
		return playerRepo.findAll();
	}

	/**
	 * Get a <Player> object from the database by ID.
	 * 
	 * @param id unique player identifier.
	 * @return a <Player> object.
	 */
	@Override
	public Player getPlayerById(Long id) {
		Optional<Player> player = playerRepo.findById(id);
		if (player.isPresent()) {
			return player.get();
		}
		throw new ResourceNotFoundException("Player is not found for the id " + id);
	}

	/**
	 * Update a <Player> object in the database.
	 * 
	 * @param player <Player> object.
	 * @param id     unique player identifier.
	 * @return a <Player> object.
	 */
	@Override
	public Player updatePlayer(Long id, Player player) {
		Player existingPlayer = getPlayerById(id);
		existingPlayer
				.setFirstName(player.getFirstName() != null ? player.getFirstName() : existingPlayer.getFirstName());
		existingPlayer.setLastName(player.getLastName() != null ? player.getLastName() : existingPlayer.getLastName());
		existingPlayer.setAge(player.getAge() != null ? player.getAge() : existingPlayer.getAge());
		existingPlayer.setHeight(player.getHeight() != null ? player.getHeight() : existingPlayer.getHeight());
		existingPlayer.setWeight(player.getWeight() != null ? player.getWeight() : existingPlayer.getWeight());
		existingPlayer.setNationality(
				player.getNationality() != null ? player.getNationality() : existingPlayer.getNationality());
		existingPlayer.setStatus(player.getStatus() != null ? player.getStatus() : existingPlayer.getStatus());
		existingPlayer.setGamesPlayed(
				player.getGamesPlayed() != null ? player.getGamesPlayed() : existingPlayer.getGamesPlayed());
		existingPlayer.setWins(player.getWins() != null ? player.getWins() : existingPlayer.getWins());
		existingPlayer.setLosses(player.getLosses() != null ? player.getLosses() : existingPlayer.getLosses());

		return playerRepo.save(existingPlayer);
	}

	/**
	 * Delete a <Player> from the database.
	 * 
	 * @param id unique player identifier.
	 */
	@Override
	public void deletePlayerById(Long id) {
		Player player = getPlayerById(id);
		playerRepo.delete(player);
	}
}
