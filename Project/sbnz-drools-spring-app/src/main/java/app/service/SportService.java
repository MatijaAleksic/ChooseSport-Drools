package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Sport;
import app.repository.SportRepository;

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
