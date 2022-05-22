package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import app.enums.CenaSporta;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Sport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	private String ime;
	
	private int preciznost;
	private int izdrzljivost;
	private int tehnika;
	private int brzina;
	private int snaga;
	
	private CenaSporta cena;
	
	private int vezbeSnage;
	private int vezbeIzdrzljivosti;
	
	
	public Sport() {
		super();
	}

	public Sport(Long id,String ime, int preciznost, int izdrzljivost, int tehnika, int brzina, int snaga, CenaSporta cena,
			int vezbeSnage, int vezbeIzdrzljivosti) {
		super();
		this.id = id;
		this.ime = ime;
		this.preciznost = preciznost;
		this.izdrzljivost = izdrzljivost;
		this.tehnika = tehnika;
		this.brzina = brzina;
		this.snaga = snaga;
		this.cena = cena;
		this.vezbeSnage = vezbeSnage;
		this.vezbeIzdrzljivosti = vezbeIzdrzljivosti;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPreciznost() {
		return preciznost;
	}

	public void setPreciznost(int preciznost) {
		this.preciznost = preciznost;
	}

	public int getIzdrzljivost() {
		return izdrzljivost;
	}

	public void setIzdrzljivost(int izdrzljivost) {
		this.izdrzljivost = izdrzljivost;
	}

	public int getTehnika() {
		return tehnika;
	}

	public void setTehnika(int tehnika) {
		this.tehnika = tehnika;
	}

	public int getBrzina() {
		return brzina;
	}

	public void setBrzina(int brzina) {
		this.brzina = brzina;
	}

	public int getSnaga() {
		return snaga;
	}

	public void setSnaga(int snaga) {
		this.snaga = snaga;
	}

	public CenaSporta getCena() {
		return cena;
	}

	public void setCena(CenaSporta cena) {
		this.cena = cena;
	}

	public int getVezbeSnage() {
		return vezbeSnage;
	}

	public void setVezbeSnage(int vezbeSnage) {
		this.vezbeSnage = vezbeSnage;
	}

	public int getVezbeIzdrzljivosti() {
		return vezbeIzdrzljivosti;
	}

	public void setVezbeIzdrzljivosti(int vezbeIzdrzljivosti) {
		this.vezbeIzdrzljivosti = vezbeIzdrzljivosti;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

}