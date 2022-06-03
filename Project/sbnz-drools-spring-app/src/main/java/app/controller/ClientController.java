package app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.dto.BMIDto;
import app.dto.KrvniPritisakDTO;
import app.enums.BMIStatus;
import app.enums.KrvniPritisakStatus;
import app.exceptions.UserNotFoundExcpetion;
import app.model.BMI;
import app.model.KrvniPritisak;
import app.service.BMIService;
import app.service.ClientService;
import app.service.KrvniPritisakService;

@RestController
public class ClientController {
	private static Logger log = LoggerFactory.getLogger(SampleAppController.class);

	private final ClientService clientService;
	private final BMIService bmiService;
	private final KrvniPritisakService krvniPritisakService;

	@Autowired
	public ClientController(ClientService clientService, BMIService bmiService, KrvniPritisakService krvniPritisakService) {
		this.clientService = clientService;
		this.bmiService = bmiService;
		this.krvniPritisakService = krvniPritisakService;
	}
	
	@PostMapping(value="/bmi", produces = "application/json")
	public BMI calculateBMI(@RequestBody BMIDto dto) throws Exception {
		
		BMI existing_bmi = clientService.getBMIforUser(dto.getUser_id());
		existing_bmi.setStatus(BMIStatus.NA);
		existing_bmi.setScore(0);
		
		existing_bmi.setVisina(dto.getVisina());
		existing_bmi.setTezina(dto.getTezina());
		existing_bmi.setGodine(dto.getGodine());
		
		log.debug("BMI request received for: " + existing_bmi);

		BMI updated_bmi = this.clientService.getClassifiedBMI(existing_bmi);
		
		this.bmiService.save(updated_bmi);
		
		return updated_bmi;
	}
	
	@PostMapping(value="/krvni_pritisak", produces = "application/json")
	public KrvniPritisak calculateKrvniPritisak(@RequestBody KrvniPritisakDTO dto) throws Exception {
		
		KrvniPritisak existing_kp = clientService.getKrvniPritisakforUser(dto.getUser_id());
		
		existing_kp.setStatus(KrvniPritisakStatus.NA);
		
		existing_kp.setDonji_pritisak(dto.getDonji_pritisak());
		existing_kp.setGornji_pritisak(dto.getGornji_pritisak());

		log.debug("Krvni Pritisak request received for: " + existing_kp);

		KrvniPritisak updated_bmi = this.clientService.getClassifiedKrvniPritisak(existing_kp);
		
		this.krvniPritisakService.save(updated_bmi);
		
		return updated_bmi;
	}
	
//	@PostMapping(value="/sport_specifications", produces = "application/json")
//	public KrvniPritisak calculateKrvniPritisak(@RequestBody KrvniPritisakDTO dto) throws Exception {
//		
//		KrvniPritisak existing_kp = clientService.getKrvniPritisakforUser(dto.getUser_id());
//		
//		existing_kp.setStatus(KrvniPritisakStatus.NA);
//		
//		existing_kp.setDonji_pritisak(dto.getDonji_pritisak());
//		existing_kp.setGornji_pritisak(dto.getGornji_pritisak());
//
//		log.debug("Krvni Pritisak request received for: " + existing_kp);
//
//		KrvniPritisak updated_bmi = this.clientService.getClassifiedKrvniPritisak(existing_kp);
//		
//		this.krvniPritisakService.save(updated_bmi);
//		
//		return updated_bmi;
//	}


}
