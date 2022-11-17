package lt.viko.eif.vytzab.restws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.viko.eif.vytzab.restws.entities.Player;

/**
 * @author Vytautas
 *
 *         Interface to perform JPA operations on an in-memory database.
 */
@Repository
public interface IPlayerRepository extends JpaRepository<Player, Long> {

}
