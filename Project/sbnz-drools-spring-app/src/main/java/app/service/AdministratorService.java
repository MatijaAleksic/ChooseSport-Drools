package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.RegisterDTO;
import app.exceptions.UserNotFoundExcpetion;
import app.model.Administrator;
import app.repository.AdministratorRepository;

@Service
public class AdministratorService {

	private AdministratorRepository administratorRepository;
	
	@Autowired
	public AdministratorService(AdministratorRepository administratorRepository) {
		this.administratorRepository = administratorRepository;
	}
	
	
	public List<Administrator> findAll() throws UserNotFoundExcpetion{
		List<Administrator> found = administratorRepository.findAll();
		if(found == null) {
			throw new UserNotFoundExcpetion("No users found in method findAll() -> administrators: ");
		}
		
		return found;
	}
	
	public Administrator create(RegisterDTO registerDTO) throws UserNotFoundExcpetion {
		
		Administrator existingAdmin = this.administratorRepository.findByEmail(registerDTO.getEmail());
		if(existingAdmin != null) {
			throw new UserNotFoundExcpetion("User with given email alredy exists");
		}
		Administrator newAdmin = new Administrator(registerDTO.getEmail(), registerDTO.getPassword());
		return this.administratorRepository.save(newAdmin);
		
	}
}
