package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import app.enums.TimskaPodkategorija;

@Entity
@Table(name = "timska_kategorija")
public class TimskaKategorija {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private TimskaPodkategorija podkategorija;
	
	@ManyToOne
	@JoinColumn(name = "tim_sport_id", nullable = true)
	private TimskiSport sport;
	

	public TimskaKategorija() {
		super();
	}

	public TimskaKategorija(Long id, TimskaPodkategorija podkategorija, TimskiSport sport) {
		super();
		this.id = id;
		this.podkategorija = podkategorija;
		this.sport = sport;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TimskaPodkategorija getPodkategorija() {
		return podkategorija;
	}

	public void setPodkategorija(TimskaPodkategorija podkategorija) {
		this.podkategorija = podkategorija;
	}

	public TimskiSport getSport() {
		return sport;
	}

	public void setSport(TimskiSport sport) {
		this.sport = sport;
	}
	
	

}
