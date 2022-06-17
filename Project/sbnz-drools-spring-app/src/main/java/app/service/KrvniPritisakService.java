package app.service;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.KrvniPritisak;
import app.repository.KrvniPritisakRepository;

@Service
public class KrvniPritisakService {
	
//	private static Logger log = LoggerFactory.getLogger(ClientService.class);

	private final KrvniPritisakRepository repository;
	
	@Autowired
	public KrvniPritisakService(KrvniPritisakRepository kp_repository) {
		this.repository = kp_repository;
	}
	
	public KrvniPritisak save(KrvniPritisak entity) throws Exception {
        return repository.save(entity);
    }

}
