package lt.viko.eif.vytzab.restws.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lt.viko.eif.vytzab.restws.entities.Player;
import lt.viko.eif.vytzab.restws.services.IPlayerService;

/**
 * @author Vytautas
 *
 *         Class for the REST calls implementation.
 */
@CrossOrigin
@RestController
public class PlayerController {

	/**
	 * An instance of the <IPlayerService> in order to perform operations on the
	 * in-memory database.
	 */
	@Autowired
	private IPlayerService playerService;

	/**
	 * Get a <Player> object from the database.
	 * 
	 * @param player <Player> object.
	 * @return a <Player> object.
	 */
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/players")
	public Player createPlayer(@Valid @RequestBody Player player) {
		return playerService.createPlayer(player);
	}

	/**
	 * Get all <Player> objects from the database.
	 * 
	 * @return a list of <Player> objects.
	 */
	@GetMapping("/players")
	public List<Player> getPlayers() {
		return playerService.getPlayers();
	}

	/**
	 * Get a <Player> object from the database by ID.
	 * 
	 * @param id unique player identifier.
	 * @return a <Player> object.
	 */
	@GetMapping("/players/{id}")
	public Player getPlayerById(@PathVariable Long id) {
		return playerService.getPlayerById(id);
	}

	/**
	 * Update a <Player> object in the database.
	 * 
	 * @param player <Player> object.
	 * @param id     unique player identifier.
	 * @return a <Player> object.
	 */
	@PutMapping("/players/{id}")
	public Player updatePlayer(@RequestBody Player player, @PathVariable Long id) {
		return playerService.updatePlayer(id, player);
	}

	/**
	 * Delete a <Player> from the database.
	 * 
	 * @param id unique player identifier.
	 */
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping("/players/{id}")
	public void deletePlayerById(@PathVariable Long id) {
		playerService.deletePlayerById(id);
	}

}
