package app.controller;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.dto.BMIDto;
import app.dto.HeartBeatDTO;
import app.dto.KrvniPritisakDTO;
import app.dto.PreporukaTreningaDTO;
import app.dto.QuerySportDTO;
import app.enums.BMIStatus;
import app.enums.KrvniPritisakStatus;
import app.model.BMI;
import app.model.Client;
import app.model.KrvniPritisak;
import app.model.User;
import app.service.BMIService;
import app.service.ClientService;
import app.service.EkstremniSportService;
import app.service.IndividualniSportService;
import app.service.KrvniPritisakService;
import app.service.TimskiSportService;

@RestController
@RequestMapping(value = "/client", consumes="application/json")
public class ClientController {
	private static Logger log = LoggerFactory.getLogger(ClientController.class);

	private final ClientService clientService;
	private final BMIService bmiService;
	private final KrvniPritisakService krvniPritisakService;
	
	private IndividualniSportService individualniSportService;
	private TimskiSportService timskiSportService;
	private EkstremniSportService ekstremniSportService;

	@Autowired
	public ClientController(ClientService clientService, BMIService bmiService, KrvniPritisakService krvniPritisakService,
			IndividualniSportService individualniSportService,TimskiSportService timskiSportService, EkstremniSportService ekstremniSportService) {
		this.clientService = clientService;
		this.bmiService = bmiService;
		this.krvniPritisakService = krvniPritisakService;
		
		this.individualniSportService = individualniSportService;
		this.timskiSportService = timskiSportService;
		this.ekstremniSportService = ekstremniSportService;
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
	
	@PostMapping(value="/sport_query", produces = "application/json")
	public QuerySportDTO calculateSport(@RequestBody QuerySportDTO dto) throws Exception {

		dto.setIndividualniSportovi(this.individualniSportService.findAll());
		dto.setTimskiSports(this.timskiSportService.findAll());
		dto.setEkstremniSports(this.ekstremniSportService.findAll());

		QuerySportDTO query_result = this.clientService.getClassifiedSport(dto);
		
		Client client = this.clientService.findById(dto.getUserId());
		
		
		return query_result;
		
	}
	
	@PostMapping(value="/trening", produces = "application/json")
	public PreporukaTreningaDTO testTrening(@RequestBody PreporukaTreningaDTO dto) throws Exception {

//		Client client = this.clientService.findById(1L);
//		
//		dto.setBmiStatus(client.getBmi().getStatus());
//		dto.setKpStatus(client.getPritisak().getStatus());

		PreporukaTreningaDTO query_result = this.clientService.getClassifiedTrening(dto);
		
		return query_result;
		
	}
	
	@GetMapping(value="/test/{name}", produces = "application/json")
	public ResponseEntity<?> calculateSport(@PathVariable String name) throws Exception {
		
		if(name.equals("individualni")) {
			return new ResponseEntity<>(this.individualniSportService.findAll(), HttpStatus.OK);
		}
		else if(name.equals("timski")) {
			return new ResponseEntity<>(this.timskiSportService.findAll(), HttpStatus.OK);
		}
		else if(name.equals("ekstremni")) {
			return new ResponseEntity<>(this.ekstremniSportService.findAll(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/heart_beat", produces = "application/json")
	public HeartBeatDTO cepHeartBeat(@RequestBody HeartBeatDTO heartBeat) throws Exception {
		
		Client user = this.clientService.findById(heartBeat.getUserId());
		heartBeat.setBmiStatus(user.getBmi().getStatus());
		heartBeat.setKrvniPritisak(user.getPritisak().getStatus());
		heartBeat.setUserAge(user.getBmi().getGodine());
		heartBeat.calculateUpperLowerLimit();
		heartBeat.setTimeNow(LocalDateTime.now());
		
		HeartBeatDTO result = this.clientService.getClassifiedHeartRate(heartBeat);
		return result;
	}
}