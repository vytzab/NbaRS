package lt.viko.eif.vytzab.restws.model;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "record", propOrder = { "gamesplayed", "wins", "losses" })
public class Record {

	@XmlElement(required = true)
	protected BigInteger gamesplayed;
	@XmlElement(required = true)
	protected BigInteger wins;
	@XmlElement(required = true)
	protected BigInteger losses;

	/**
	 * @return the gamesplayed
	 */
	public BigInteger getGamesplayed() {
		return gamesplayed;
	}

	/**
	 * @param gamesplayed the gamesplayed to set
	 */
	public void setGamesplayed(BigInteger gamesplayed) {
		this.gamesplayed = gamesplayed;
	}

	/**
	 * @return the wins
	 */
	public BigInteger getWins() {
		return wins;
	}

	/**
	 * @param wins the wins to set
	 */
	public void setWins(BigInteger wins) {
		this.wins = wins;
	}

	/**
	 * @return the losses
	 */
	public BigInteger getLosses() {
		return losses;
	}

	/**
	 * @param losses the losses to set
	 */
	public void setLosses(BigInteger losses) {
		this.losses = losses;
	}

}
