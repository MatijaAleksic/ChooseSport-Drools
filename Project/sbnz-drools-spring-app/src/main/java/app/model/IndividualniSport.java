package app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import app.enums.CenaSporta;

@Entity
@Table(name = "individualni_sport")
public class IndividualniSport extends Sport {
	

	@OneToMany(mappedBy = "sport", fetch = FetchType.LAZY)
	private Set<IndividualnaKategorija> kategorije = new HashSet<>();
	
	public IndividualniSport() {
		super();
	}
	
	public IndividualniSport(Long id,String ime, int preciznost, int izdrzljivost, int tehnika, int brzina, int snaga, CenaSporta cena,
			int vezbeSnage, int vezbeIzdrzljivosti) {
		super(id,ime,preciznost, izdrzljivost, tehnika,brzina,snaga,cena,vezbeSnage, vezbeIzdrzljivosti);
	}

	public Set<IndividualnaKategorija> getKategorije() {
		return kategorije;
	}

	public void setKategorije(Set<IndividualnaKategorija> kategorije) {
		this.kategorije = kategorije;
	}
	
}
