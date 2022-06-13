package app.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import app.enums.CenaSporta;
import app.enums.EkstremnaPodkategorija;
import app.enums.IndividualnaPodkategorija;
import app.enums.TimskaPodkategorija;
import app.enums.TipSporta;
import app.model.EkstremniSport;
import app.model.IndividualnaKategorija;
import app.model.IndividualniSport;
import app.model.Sport;
import app.model.TimskiSport;

public class QuerySportDTO {
	
	public Long userId;
	public int preciznost;
	public int izdrzljivost;
	public int tehnika;
	public int brzina;
	public int snaga;
	
	private CenaSporta cena;
	
	private TipSporta tipSporta;
	
	private IndividualnaPodkategorija indPodkategorija;
	private EkstremnaPodkategorija eksPodkategorija;
	private TimskaPodkategorija timPodkategorija;
	
	
	private List<IndividualniSport> individualniSportovi = null;
	private List<TimskiSport> timskiSports = null;
	private List<EkstremniSport> ekstremniSports = null;
	
	private List<? extends Sport> odabrani_tip;
	
	private Sport odabraniSport;


	public QuerySportDTO() {}

	public QuerySportDTO(int preciznost, int izdrzljivost, int tehnika, int brzina, int snaga, CenaSporta cena,
			TipSporta tipSporta, IndividualnaPodkategorija indPodkategorija, EkstremnaPodkategorija eksPodkategorija,
			TimskaPodkategorija timPodkategorija) {
		super();
		this.preciznost = preciznost;
		this.izdrzljivost = izdrzljivost;
		this.tehnika = tehnika;
		this.brzina = brzina;
		this.snaga = snaga;
		this.cena = cena;
		this.tipSporta = tipSporta;
		this.indPodkategorija = indPodkategorija;
		this.eksPodkategorija = eksPodkategorija;
		this.timPodkategorija = timPodkategorija;
	}
	
	public void izaberiTipSporta(TipSporta tipSporta) {
		
		if(tipSporta == TipSporta.INDIVIDUALNI) {
			
			this.tipSporta = tipSporta;
			this.odabrani_tip = this.individualniSportovi;
			
			this.ekstremniSports = null;
			this.timskiSports = null;
			this.individualniSportovi = null;
			
		}else if(tipSporta == TipSporta.EKSTREMNI) {
			
			this.tipSporta = tipSporta;
			this.odabrani_tip = this.ekstremniSports;
			
			this.individualniSportovi = null;
			this.timskiSports = null;
			this.ekstremniSports = null;
		}
		else if(tipSporta == TipSporta.TIMSKI) {
			
			this.tipSporta = tipSporta;
			this.odabrani_tip = this.timskiSports;
			
			this.ekstremniSports = null;
			this.individualniSportovi = null;
			this.timskiSports = null;

		}
	}

	public List<IndividualniSport> getIndividualniSportovi() {
		return individualniSportovi;
	}

	public void setIndividualniSportovi(List<IndividualniSport> individualniSportovi) {
		this.individualniSportovi = individualniSportovi;
	}

	public List<TimskiSport> getTimskiSports() {
		return timskiSports;
	}

	public void setTimskiSports(List<TimskiSport> timskiSports) {
		this.timskiSports = timskiSports;
	}

	public List<EkstremniSport> getEkstremniSports() {
		return ekstremniSports;
	}

	public void setEkstremniSports(List<EkstremniSport> ekstremniSports) {
		this.ekstremniSports = ekstremniSports;
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

	public TipSporta getTipSporta() {
		return tipSporta;
	}

	public void setTipSporta(TipSporta tipSporta) {
		this.tipSporta = tipSporta;
	}

	public IndividualnaPodkategorija getIndPodkategorija() {
		return indPodkategorija;
	}

	public void setIndPodkategorija(IndividualnaPodkategorija indPodkategorija) {
		this.indPodkategorija = indPodkategorija;
	}

	public List<? extends Sport> getOdabrani_tip() {
		return odabrani_tip;
	}

	public void setOdabrani_tip(List<? extends Sport> odabrani_tip) {
		this.odabrani_tip = odabrani_tip;
	}

	public Sport getOdabraniSport() {
		return odabraniSport;
	}

	public void setOdabraniSport(Sport odabraniSport) {
		this.odabraniSport = odabraniSport;
	}
	
	public void removeOdabraniSport(Sport remove) {
		this.odabrani_tip.remove(remove);
	}
	
	public void addOdabraniSport( Sport add) {
		ArrayList<Sport> temp = (ArrayList<Sport>) this.odabrani_tip;
		temp.add(add);
		this.odabrani_tip = temp;

	}

	public EkstremnaPodkategorija getEksPodkategorija() {
		return eksPodkategorija;
	}

	public void setEksPodkategorija(EkstremnaPodkategorija eksPodkategorija) {
		this.eksPodkategorija = eksPodkategorija;
	}

	public TimskaPodkategorija getTimPodkategorija() {
		return timPodkategorija;
	}

	public void setTimPodkategorija(TimskaPodkategorija timPodkategorija) {
		this.timPodkategorija = timPodkategorija;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
	
//
//    $sport : IndividualniSport(kategorije.size() > 0) from $sports;
//    $kategorije : List() from collect ( IndividualnaKategorija($sporta : sport, podkategorija == $podkat) from $sport.kategorije );
//    
//    $filtered_sports : List() from collect ( IndividualniSport() from $kategorije );
//    

}