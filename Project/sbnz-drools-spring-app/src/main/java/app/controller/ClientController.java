package app.controller;

import org.springframework.http.HttpStatus;

import java.time.Duration;
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
import app.model.Notification;
import app.service.BMIService;
import app.service.ClientService;
import app.service.EkstremniSportService;
import app.service.IndividualniSportService;
import app.service.KrvniPritisakService;
import app.service.NotificationService;
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
	
	private NotificationService notificationService;

	@Autowired
	public ClientController(ClientService clientService, BMIService bmiService, KrvniPritisakService krvniPritisakService,
			IndividualniSportService individualniSportService,TimskiSportService timskiSportService, EkstremniSportService ekstremniSportService,
			NotificationService notificationService) {
		this.clientService = clientService;
		this.bmiService = bmiService;
		this.krvniPritisakService = krvniPritisakService;
		
		this.individualniSportService = individualniSportService;
		this.timskiSportService = timskiSportService;
		this.ekstremniSportService = ekstremniSportService;
		
		this.notificationService = notificationService;
	}
	
	@PostMapping(value="/bmi", produces = "application/json")
	public BMI calculateBMI(@RequestBody BMIDto dto) throws Exception {
		
		Client temp = this.clientService.findById(dto.getUser_id());
		BMI bmi_temp = null;
		
		if(temp.getBmi() == null) {
			bmi_temp = new BMI();
		}
		else {
			bmi_temp = temp.getBmi();
		}
		
		bmi_temp.setStatus(BMIStatus.NA);
		bmi_temp.setScore(0);
		
		bmi_temp.setVisina(dto.getVisina());
		bmi_temp.setTezina(dto.getTezina());
		bmi_temp.setGodine(dto.getGodine());
		
		BMI updated_bmi = this.clientService.getClassifiedBMI(bmi_temp);
		
		BMI saved_bmi = this.bmiService.save(updated_bmi);
		
		if(temp.getBmi() == null) {
			temp.setBmi(saved_bmi);
			this.clientService.save(temp);
		}
		
		return updated_bmi;
	}
	
	@PostMapping(value="/krvni_pritisak", produces = "application/json")
	public KrvniPritisak calculateKrvniPritisak(@RequestBody KrvniPritisakDTO dto) throws Exception {
		
		Client temp = this.clientService.findById(dto.getUser_id());
		KrvniPritisak kp_temp = null;
		
		if(temp.getPritisak() == null) {
			kp_temp = new KrvniPritisak();
		}
		else {
			kp_temp = temp.getPritisak();
		}

		kp_temp.setStatus(KrvniPritisakStatus.NA);
		
		kp_temp.setDonji_pritisak(dto.getDonji_pritisak());
		kp_temp.setGornji_pritisak(dto.getGornji_pritisak());

		KrvniPritisak updated_kp = this.clientService.getClassifiedKrvniPritisak(kp_temp);
		
	
		KrvniPritisak saved_kp = this.krvniPritisakService.save(updated_kp);
		
		if(temp.getPritisak() == null) {
			temp.setPritisak(saved_kp);
			this.clientService.save(temp);
		}
		
		return updated_kp;
	}
	
	@PostMapping(value="/sport_query", produces = "application/json")
	public QuerySportDTO calculateSport(@RequestBody QuerySportDTO dto) throws Exception {

		dto.printQuert();
		
		dto.setIndividualniSportovi(this.individualniSportService.findAll());
		dto.setTimskiSports(this.timskiSportService.findAll());
		dto.setEkstremniSports(this.ekstremniSportService.findAll());

		QuerySportDTO query_result = this.clientService.getClassifiedSport(dto);
		
		Client client = this.clientService.findById(dto.getUserId());
		client.setSport(query_result.getOdabraniSport());
		this.clientService.save(client);
		
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
	
	
	@PostMapping(value="/heart_beat", produces = "application/json")
	public void cepHeartBeat(@RequestBody HeartBeatDTO heartBeat) throws Exception {
		
		Client user = this.clientService.findById(heartBeat.getUserId());
		heartBeat.setBmiStatus(user.getBmi().getStatus());
		heartBeat.setKrvniPritisak(user.getPritisak().getStatus());
		heartBeat.setUserAge(user.getBmi().getGodine());
		heartBeat.calculateUpperLowerLimit();
		heartBeat.setTimeNow(LocalDateTime.now());
		
		HeartBeatDTO result = this.clientService.getClassifiedHeartRate(heartBeat);
		
		if(result.getText() != null) {
			Notification novaNotifikacija = new Notification();
			
			novaNotifikacija.setDate(LocalDateTime.now());
			novaNotifikacija.setText(result.getText());
			novaNotifikacija.setUser(user);
			
			this.notificationService.create(novaNotifikacija);
		}
		
	}
}