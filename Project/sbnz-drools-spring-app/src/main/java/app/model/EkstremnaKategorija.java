package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import app.enums.EkstremnaPodkategorija;

@Entity
@Table(name = "ekstremna_kategorija")
public class EkstremnaKategorija {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private EkstremnaPodkategorija podkategorija;
	
	@ManyToOne
	@JoinColumn(name = "ekst_sport_id", nullable = true)
	private EkstremniSport sport;

	
	public EkstremnaKategorija() {
		super();
	}

	public EkstremnaKategorija(Long id, EkstremnaPodkategorija podkategorija, EkstremniSport sport) {
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

	public EkstremnaPodkategorija getPodkategorija() {
		return podkategorija;
	}

	public void setPodkategorija(EkstremnaPodkategorija podkategorija) {
		this.podkategorija = podkategorija;
	}

	public EkstremniSport getSport() {
		return sport;
	}

	public void setSport(EkstremniSport sport) {
		this.sport = sport;
	}
	
}