package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.IndividualniSport;
import app.repository.IndividualniSportRepository;

@Service
public class IndividualniSportService {
	
	private final IndividualniSportRepository individualniRepository;

	
	@Autowired
	public IndividualniSportService(IndividualniSportRepository individualniRepository) {
		this.individualniRepository = individualniRepository;
	}
	
	public List<IndividualniSport> findAll() {
		
		return this.individualniRepository.findAll();
	}

}
