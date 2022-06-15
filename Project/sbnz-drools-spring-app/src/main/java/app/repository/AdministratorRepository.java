package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Long>{
	
	Administrator findByEmail(String email);

}
