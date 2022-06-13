package app.service;

import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;

import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.internal.utils.KieService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.HeartBeatDTO;
import app.dto.PreporukaTreningaDTO;
import app.dto.QuerySportDTO;
import app.enums.HeartBeatStatus;
import app.exceptions.UserNotFoundExcpetion;
import app.model.BMI;
import app.model.Client;
import app.model.KrvniPritisak;
import app.repository.ClientRepository;

@Service
public class ClientService {
	
	private static Logger log = LoggerFactory.getLogger(ClientService.class);
	
	private final KieContainer kieContainer;
	private final KieServices kieService;
	private final ClientRepository repository;
	private KieSession kieSession;
	
	
	@Autowired
	public ClientService(KieContainer kieContainer, ClientRepository client_repository, KieServices kieService, KieSession kieSession) {
		log.info("Initialising a new example session.");
		this.kieContainer = kieContainer;
		this.repository = client_repository;
		this.kieService = kieService;
		this.kieSession = kieSession;
	}
	
	public Client findById(Long userId) throws UserNotFoundExcpetion {
		Client existing_client =  repository.findById(userId).orElse(null);
		
		if(existing_client == null) {
			throw new UserNotFoundExcpetion("User by given id: " + userId.toString() + "");
		}
		
		return existing_client;
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
		this.kieSession = this.kieContainer.newKieSession();
		this.kieSession.insert(bmi);
		this.kieSession.fireAllRules();
		this.kieSession.dispose();
		return bmi;
	}
	
	public KrvniPritisak getClassifiedKrvniPritisak(KrvniPritisak kp) {
		this.kieSession = this.kieContainer.newKieSession();
		this.kieSession.insert(kp);
		this.kieSession.fireAllRules();
		this.kieSession.dispose();
		
		return kp;
	}
	
	public QuerySportDTO getClassifiedSport(QuerySportDTO qs) {
		this.kieSession = this.kieContainer.newKieSession();
		this.kieSession.insert(qs);
		this.kieSession.fireAllRules();
		this.kieSession.dispose();
		return qs;
	}
	
	public PreporukaTreningaDTO getClassifiedTrening(PreporukaTreningaDTO qs) {
		this.kieSession = this.kieContainer.newKieSession();
		this.kieSession.insert(qs);
		this.kieSession.fireAllRules();
		this.kieSession.dispose();
		return qs;
	}
	
	//VIDEO CEPA
//	https://blog.kie.org/2021/10/event-driven-drools-cep-complex-event-processing-explained.html
	public HeartBeatDTO getClassifiedHeartRate(HeartBeatDTO hb) throws InterruptedException {
		
		if(hb.getHeartBeatStatus() == HeartBeatStatus.ACTIVATE)
		{
			KieBaseConfiguration kbconf = kieService.newKieBaseConfiguration();
			kbconf.setOption(EventProcessingOption.STREAM);
		
			KieBase kieBase = this.kieContainer.newKieBase(kbconf);
		
			this.kieSession = kieBase.newKieSession();
		
			Deque<HeartBeatDTO> check = new ArrayDeque<>();
			this.kieSession.setGlobal("controlSet", check);
			
			this.kieSession.insert(hb);
			
			this.kieSession.fireAllRules();
		}
		else if(hb.getHeartBeatStatus() == HeartBeatStatus.ONGOING) {
			this.kieSession.insert(hb);
			this.kieSession.fireAllRules();
		}
		else if(hb.getHeartBeatStatus() == HeartBeatStatus.DEACTIVE)
		{
			this.kieSession.insert(hb);
			this.kieSession.fireAllRules();
			this.kieSession.dispose();
			
			this.kieSession = this.kieContainer.newKieSession();
		}
		
		return hb;
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
	

	
//	
//    $sport : IndividualniSport() from accumulate(
//	IndividualniSport($temp : this) from $sports,
//	init(IndividualniSport odabrani_sport = null; int skor = 0),
//	        	action(
//			int skor = $temp.calculateMatchScore($preciznost,$izdrzljivost,$tehnika,$brzina,$snaga);
//			
//			if($max == skor){
//				odabrani_sport = $temp;
//			}
//			),
//	result($temp)
//);
	
	
	
	
	
	
	
	
	
	//	    init( Person minp = null; Date mind = new Date(); ),
//action( if( $cd.compareTo( mind ) < 0 ){
//            minp = $child;
//            mind = $cd;
//        } ),
//result( minp ) )


//    $sport : IndividualniSport() from accumulate(
//IndividualniSport($temp : this) from $sports,
//init(IndividualniSport odabrani_sport = null; int skor = 0),
//    	action(
//	int skor = $temp.calculateMatchScore($preciznost,$izdrzljivost,$tehnika,$brzina,$snaga);
//	
//	if($max == skor){
//		odabrani_sport = $temp;
//	}
//	),
//result($temp)
}
