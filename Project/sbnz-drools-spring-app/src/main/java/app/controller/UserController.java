package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.LoginDTO;
import app.dto.LoginResponseDTO;
import app.dto.RegisterDTO;
import app.model.Administrator;
import app.model.Client;
import app.model.User;
import app.service.AdministratorService;
import app.service.ClientService;


@RestController
@RequestMapping(value = "/user", consumes="application/json")
public class UserController {
	
	private ClientService clientService;
	private AdministratorService administratorService;

	@Autowired
	public UserController(ClientService clientService, AdministratorService administratorService) {
		this.clientService = clientService;
		this.administratorService = administratorService;
	}
	
	@PostMapping(value="/login", produces = "application/json")
	public ResponseEntity<?> login(@RequestBody LoginDTO dto) throws Exception {
		
		List<Client> clients = this.clientService.findAll();
		List<Administrator> admins = this.administratorService.findAll();

		LoginResponseDTO response = new LoginResponseDTO();
		
		User currentUser = null;
				
		for(Administrator admin : admins) {
			if(dto.getEmail().equals(admin.getEmail()) && dto.getPassword().equals(admin.getPassword())) {
				currentUser = admin;
				response.setRole("admin");
			}
		}
		for(Client cli : clients) {
			if(dto.getEmail().equals(cli.getEmail()) && dto.getPassword().equals(cli.getPassword())) {
				currentUser = cli;
				response.setRole("client");
			}
		}
		
		if(currentUser == null) {
			return new ResponseEntity<>("Login unsuccessful!",  HttpStatus.UNAUTHORIZED);
		}
		
		response.setUser(currentUser);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(value="/register-admin", produces = "application/json")
	public ResponseEntity<?> registerAdmin(@RequestBody RegisterDTO dto) throws Exception {
		
		try{
            return new ResponseEntity<>(this.administratorService.create(dto), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Registeration unsuccesfull!", HttpStatus.NOT_ACCEPTABLE);
        }
	}
	
	@PostMapping(value="/register-client", produces = "application/json")
	public ResponseEntity<?> registerClient(@RequestBody RegisterDTO dto) throws Exception {
		
		try{
            return new ResponseEntity<>(this.clientService.create(dto), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Registeration unsuccesfull!", HttpStatus.NOT_ACCEPTABLE);
        }
	}

	
	

}
