package app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import app.enums.CenaSporta;

@Entity
@Table(name = "timski_sport")
public class TimskiSport extends Sport{
	
	@OneToMany(mappedBy = "sport")
	private Set<TimskaKategorija> kategorije = new HashSet<>();
	
	public TimskiSport() {
		super();
	}
	
	public TimskiSport(Long id,String ime, int preciznost, int izdrzljivost, int tehnika, int brzina, int snaga, CenaSporta cena,
			int vezbeSnage, int vezbeIzdrzljivosti) {
		super(id,ime,preciznost, izdrzljivost, tehnika,brzina,snaga,cena,vezbeSnage, vezbeIzdrzljivosti);
	}

	public Set<TimskaKategorija> getKategorije() {
		return kategorije;
	}

	public void setKategorije(Set<TimskaKategorija> kategorije) {
		this.kategorije = kategorije;
	}
	
}