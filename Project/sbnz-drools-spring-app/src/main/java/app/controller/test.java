package app.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import app.enums.TipSporta;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

import app.model.IndividualniSport;
import app.model.Sport;

public class test {
	
	public static void main(String[] args) {
//		List<? extends Sport> result;
//		List<IndividualniSport> ind = new ArrayList<IndividualniSport>();
//		
//		IndividualniSport a = new IndividualniSport();
//		a.setId(1L);
//		a.setIme("Sport1");
//		
//		IndividualniSport b = new IndividualniSport();
//		b.setId(2L);
//		b.setIme("Sport2");
//		
//		ind.add(a);
//		ind.add(b);
//		
//		result = ind;
//		
//		System.out.print(result);
		
//		TipSporta a = TipSporta.INDIVIDUALNI;
//		int b = 0;
//		System.out.println(a);
////		TipSporta.values()[0];
//		
//		
//		Sport c = new IndividualniSport();
		
		
//		int age = 42;
//		int max_src = 220 - 42;
//		
//		int max, min;
//		max = (int) (max_src * 0.8);
//		min = (int) (max_src * 0.6);
//		System.out.println(max);
//		System.out.println(min);
		
		
//		LocalDateTime a = LocalDateTime.now();
//		LocalDateTime b = a.plusMinutes(2);
//		
//		System.out.println(a);
//		System.out.println(b);
//		
//		System.out.println(Duration.between(a, b).toMinutes());

		int apreciznost = 15;
		int aizdrzljivost = 26;
		int atehnika = 83;
		int abrzina = 47;
		int asnaga = 85;
		
		int preciznost = 25;
		int izdrzljivost = 76;
		int tehnika = 47;
		int brzina = 47;
		int snaga = 85;
		
		HashMap<String, Integer> abilities = new HashMap<String, Integer>();
		abilities.put("preciznost", preciznost);
		abilities.put("izdrzljivost", izdrzljivost);
		abilities.put("tehnika", tehnika);
		abilities.put("brzina", brzina);
		abilities.put("snaga", snaga);
		
		HashMap<String, Integer> priorities = (HashMap<String, Integer>) abilities.clone();
		priorities = calculatePriorities(priorities);
		
		System.out.println(abilities);
		System.out.println(priorities);
		
		
		Queue<String> names = new LinkedList<>();
		Queue<Integer> values = new LinkedList<>();

		
		while(names.size() != 5) {
			for (Map.Entry entry : priorities.entrySet()) {
				
				
				if((Integer) entry.getValue() == 1 ) {
					names.add((String)entry.getKey());
					values.add((Integer) entry.getValue());
					if(names.size() == 5) {break;}
					
				}
				else if((Integer) entry.getValue() == 2 && values.contains(1) ) {
					names.add((String)entry.getKey());
					values.add((Integer) entry.getValue());
					if(names.size() == 5) {break;}
				}
				else if((Integer) entry.getValue() == 3 && values.contains(2) ) {
					names.add((String)entry.getKey());
					values.add((Integer) entry.getValue());
					if(names.size() == 5) {break;}
				}
				else if((Integer) entry.getValue() == 4 && values.contains(3) ) {
					names.add((String)entry.getKey());
					values.add((Integer) entry.getValue());
					if(names.size() == 5) {break;}
				}
				else if((Integer) entry.getValue() == 5 && values.contains(4) ) {
					names.add((String)entry.getKey());
					values.add((Integer) entry.getValue());
					if(names.size() == 5) {break;}
				}
			}
		}
		
//		for (String element : names) {
//			System.out.println(element + " " + values.poll());
//		}
//		System.out.println(names);
				
		Queue<String> names1 = new LinkedList<>();
		
		int exceptionalAbilityCounter = 0;
		int acceptanceLevel = 50;
		
		if(preciznost > acceptanceLevel) { exceptionalAbilityCounter += 1;}
		if(izdrzljivost > acceptanceLevel) { exceptionalAbilityCounter += 1;}
		if(tehnika > acceptanceLevel) { exceptionalAbilityCounter += 1;}
		if(brzina > acceptanceLevel) { exceptionalAbilityCounter += 1;}
		if(snaga > acceptanceLevel) { exceptionalAbilityCounter += 1;}
		
		int counter = 0;
		for (String key : names)
		{
			if(counter == exceptionalAbilityCounter) {
				break;
			}
			if(priorities.get(key) == 1) {
				names1.add(key);
			}
			if(priorities.get(key) == 2) {
				names1.add(key);
			}
			if(priorities.get(key) == 3) {
				names1.add(key);
			}
			if(priorities.get(key) == 4) {
				names1.add(key);
			}
			if(priorities.get(key) == 5) {
				names1.add(key);
			}
			counter += 1;
		}
		
		System.out.println(names1);

		ArrayList<Integer> scores = new ArrayList<Integer>();
	
		for (String name: names1) {
			if(name == "preciznost") {
				scores.add(Math.abs(preciznost - apreciznost));
			}
			else if(name == "izdrzljivost") {
				scores.add(Math.abs(izdrzljivost - aizdrzljivost));
			}
			else if(name == "tehnika") {
				scores.add(Math.abs(tehnika - atehnika));
			}
			else if(name == "brzina") {
				scores.add(Math.abs(brzina - abrzina));
			}
			else if(name == "snaga") {
				scores.add(Math.abs(snaga - asnaga));
			}
        }
		
		Integer finalScore = 0;
		for(Integer score : scores) {
//			System.out.println(score);

			finalScore += score;
		}

		System.out.println(finalScore);
		
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

}
