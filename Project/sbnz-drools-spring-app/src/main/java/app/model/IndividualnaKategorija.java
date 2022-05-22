package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import app.enums.IndividualnaPodkategorija;

@Entity
@Table(name = "individualna_kategorija")
public class IndividualnaKategorija {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private IndividualnaPodkategorija podkategorija;
	
	@ManyToOne
	@JoinColumn(name = "ind_sport_id", nullable = true)
	private IndividualniSport sport;

	
	public IndividualnaKategorija() {
		super();
	}

	public IndividualnaKategorija(Long id, IndividualnaPodkategorija podkategorija, IndividualniSport sport) {
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

	public IndividualnaPodkategorija getPodkategorija() {
		return podkategorija;
	}

	public void setPodkategorija(IndividualnaPodkategorija podkategorija) {
		this.podkategorija = podkategorija;
	}

	public IndividualniSport getSport() {
		return sport;
	}

	public void setSport(IndividualniSport sport) {
		this.sport = sport;
	}
	
}
