package mawa.com.pl.springmvc.bean;

import java.util.List;
import javax.persistence.*;

@Entity
public class Team {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	@OneToMany(mappedBy = "team", targetEntity = Player.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Player> players;

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> p) {
		players = p;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}