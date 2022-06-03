package app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.BMI;
import app.repository.BMIRepository;

@Service
public class BMIService {
	
	private static Logger log = LoggerFactory.getLogger(ClientService.class);
	
	private final BMIRepository repository;
	
	
	@Autowired
	public BMIService(BMIRepository bmi_repository) {
		this.repository = bmi_repository;
	}
	
	public BMI save(BMI entity) throws Exception {
        return repository.save(entity);
    }

}
