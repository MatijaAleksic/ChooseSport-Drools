package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Sport;
import app.model.TimskiSport;
import app.repository.TimskiSportRepository;

@Service
public class TimskiSportService {
	
	private final TimskiSportRepository timskiRepository;
	
	@Autowired
	public TimskiSportService(TimskiSportRepository timskiRepository) {
		this.timskiRepository = timskiRepository;
	}
	
	public List<TimskiSport> findAll() {
		return this.timskiRepository.findAll();
	}


}
