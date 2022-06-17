package app.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

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
	
	public int calculateMatchScore(int preciznost,int izdrzljivost,int tehnika,int brzina,int snaga) {

		HashMap<String, Integer> abilities = new HashMap<String, Integer>();
		abilities.put("preciznost", preciznost);
		abilities.put("izdrzljivost", izdrzljivost);
		abilities.put("tehnika", tehnika);
		abilities.put("brzina", brzina);
		abilities.put("snaga", snaga);
		
		HashMap<String, Integer> priorities = (HashMap<String, Integer>) abilities.clone();
		priorities = calculatePriorities(priorities);
		
		Queue<String> names = new LinkedList<>();
		Queue<Integer> values = new LinkedList<>();

		while(names.size() != 5) {
			for (Map.Entry entry : priorities.entrySet()) {
				
				if((Integer) entry.getValue() == 1 && !names.contains(entry.getKey())) {
					names.add((String)entry.getKey());
					values.add((Integer) entry.getValue());
					if(names.size() == 5) {break;}
					
				}
				else if((Integer) entry.getValue() == 2 && values.contains(1) && !names.contains(entry.getKey())) {
					names.add((String)entry.getKey());
					values.add((Integer) entry.getValue());
					if(names.size() == 5) {break;}
				}
				else if((Integer) entry.getValue() == 3 && values.contains(2) && !names.contains(entry.getKey())) {
					names.add((String)entry.getKey());
					values.add((Integer) entry.getValue());
					if(names.size() == 5) {break;}
				}
				else if((Integer) entry.getValue() == 4 && values.contains(3) && !names.contains(entry.getKey())) {
					names.add((String)entry.getKey());
					values.add((Integer) entry.getValue());
					if(names.size() == 5) {break;}
				}
				else if((Integer) entry.getValue() == 5 && values.contains(4) && !names.contains(entry.getKey())) {
					names.add((String)entry.getKey());
					values.add((Integer) entry.getValue());
					if(names.size() == 5) {break;}
				}
			}
		}
		

//		System.out.println(abilities);
//		System.out.println(priorities);
				
//		Queue<String> names1 = new LinkedList<>();
//		
//		int exceptionalAbilityCounter = 0;
//		int acceptanceLevel = 50;
//		
//		if(preciznost > acceptanceLevel) { exceptionalAbilityCounter += 1;}
//		if(izdrzljivost > acceptanceLevel) { exceptionalAbilityCounter += 1;}
//		if(tehnika > acceptanceLevel) { exceptionalAbilityCounter += 1;}
//		if(brzina > acceptanceLevel) { exceptionalAbilityCounter += 1;}
//		if(snaga > acceptanceLevel) { exceptionalAbilityCounter += 1;}
//		
//		int counter = 0;
//		for (String key : names)
//		{
//			if(counter == exceptionalAbilityCounter) {
//				break;
//			}
//			if(priorities.get(key) == 1) {
//				names1.add(key);
//			}
//			if(priorities.get(key) == 2) {
//				names1.add(key);
//			}
//			if(priorities.get(key) == 3) {
//				names1.add(key);
//			}
//			if(priorities.get(key) == 4) {
//				names1.add(key);
//			}
//			if(priorities.get(key) == 5) {
//				names1.add(key);
//			}
//			counter += 1;
//		}
		

		ArrayList<Integer> scores = new ArrayList<Integer>();
	
		for (String name: names) {
			if(name == "preciznost") {
				scores.add(Math.abs(preciznost - this.preciznost));
			}
			else if(name == "izdrzljivost") {
				scores.add(Math.abs(izdrzljivost - this.izdrzljivost));
			}
			else if(name == "tehnika") {
				scores.add(Math.abs(tehnika - this.tehnika));
			}
			else if(name == "brzina") {
				scores.add(Math.abs(brzina - this.brzina));
			}
			else if(name == "snaga") {
				scores.add(Math.abs(snaga - this.snaga));
			}
        }
		
		Integer finalScore = 0;
		for(Integer score : scores) {
			finalScore += score;
		}

		//System.out.println(this.ime + " skor: " + (500 - finalScore));
		Integer result = 500 - finalScore;
		return result;

	}
	
	
	



	public static HashMap<String, Integer> calculatePriorities(HashMap<String, Integer> map){
		
		List<Integer> values = new ArrayList<Integer>(map.values());
		Collections.sort(values);
	
		for (String key : map.keySet()) {
			
			if(map.get(key) == values.get(4)) {
				map.put(key, 1);
			}
			if(map.get(key) == values.get(3)) {
				map.put(key, 2);
			}
			if(map.get(key) == values.get(2)) {
				map.put(key, 3);
			}
			if(map.get(key) == values.get(1)) {
				map.put(key, 4);
			}
			if(map.get(key) == values.get(0)) {
				map.put(key, 5);
			}
		}
		
		return map;
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