package app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import app.enums.CenaSporta;

@Entity
@Table(name = "ekstremni_sport")
public class EkstremniSport extends Sport{
	
	@OneToMany(mappedBy = "sport")
	private Set<EkstremnaKategorija> kategorije = new HashSet<>();
	
	public EkstremniSport() {
		super();
	}
	
	public EkstremniSport(Long id, String ime,int preciznost, int izdrzljivost, int tehnika, int brzina, int snaga, CenaSporta cena,
			int vezbeSnage, int vezbeIzdrzljivosti) {
		super(id,ime,preciznost, izdrzljivost, tehnika,brzina,snaga,cena,vezbeSnage, vezbeIzdrzljivosti);
	}

	public Set<EkstremnaKategorija> getKategorije() {
		return kategorije;
	}

	public void setKategorije(Set<EkstremnaKategorija> kategorije) {
		this.kategorije = kategorije;
	}
}
