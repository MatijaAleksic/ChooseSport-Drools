package app.service;

import java.util.Optional;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.exceptions.UserNotFoundExcpetion;
import app.model.BMI;
import app.model.Client;
import app.model.Item;
import app.model.KrvniPritisak;
import app.repository.ClientRepository;

@Service
public class ClientService {
	
	private static Logger log = LoggerFactory.getLogger(ClientService.class);
	
	private final KieContainer kieContainer;
	private final ClientRepository repository;
	
	
	@Autowired
	public ClientService(KieContainer kieContainer, ClientRepository client_repository) {
		log.info("Initialising a new example session.");
		this.kieContainer = kieContainer;
		this.repository = client_repository;
	}
	
	public BMI getBMIforUser(Long userId) throws UserNotFoundExcpetion {
		Client existing_client =  repository.findById(userId).orElse(null);
		
		if(existing_client == null) {
			throw new UserNotFoundExcpetion("User by given id: " + userId.toString() + "");
		}
		
		return existing_client.getBmi();
	}
	
	public KrvniPritisak getKrvniPritisakforUser(Long userId) throws UserNotFoundExcpetion {
		Client existing_client =  repository.findById(userId).orElse(null);
		
		if(existing_client == null) {
			throw new UserNotFoundExcpetion("User by given id: " + userId.toString() + "");
		}
		
		return existing_client.getPritisak();
	}
	
    public Client save(Client entity) throws Exception {
        return repository.save(entity);
    }
	
	public BMI getClassifiedBMI(BMI bmi) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(bmi);
		kieSession.fireAllRules();
		kieSession.dispose();
		return bmi;
	}
	
	public KrvniPritisak getClassifiedKrvniPritisak(KrvniPritisak kp) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(kp);
		kieSession.fireAllRules();
		kieSession.dispose();
		return kp;
	}
	
	
	
//	public ResponseEntity<?> getBMIforUser(Long userId) {
//		Client existing_client =  repository.findByBMIId(userId);
//		
//		if(existing_client == null) {
//			return new ResponseEntity<>("Year of birth cannot be in the future", HttpStatus.BAD_REQUEST);
//		}
//		
//		return new ResponseEntity<>(existing_client.getBmi(), HttpStatus.OK);
//	}
	

}
