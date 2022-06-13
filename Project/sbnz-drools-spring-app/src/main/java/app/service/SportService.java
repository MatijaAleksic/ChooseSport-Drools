package app.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.IndividualniSport;
import app.model.Sport;
import app.repository.EkstremniSportRepository;
import app.repository.IndividualniSportRepository;
import app.repository.SportRepository;
import app.repository.TimskiSportRepository;

@Service
public class SportService {
	private final SportRepository sportRepository;

	
	@Autowired
	public SportService(SportRepository sportRepository) {
		this.sportRepository = sportRepository;

	}
	
	public List<Sport> findAll() {
		
		return this.sportRepository.findAll();
	}
}
