package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
	Client findByBmiId(Long id);
}


