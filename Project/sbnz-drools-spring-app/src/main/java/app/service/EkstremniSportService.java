package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.EkstremniSport;
import app.repository.EkstremniSportRepository;

@Service
public class EkstremniSportService {
	
	private final EkstremniSportRepository ekstremniRepository;

	@Autowired
	public EkstremniSportService(EkstremniSportRepository ekstremniRepository) {
		this.ekstremniRepository = ekstremniRepository;
	}
	
	public List<EkstremniSport> findAll() {
		
		return this.ekstremniRepository.findAll();
	}

}
