package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.IndividualniSport;

@Repository
public interface IndividualniSportRepository extends JpaRepository<IndividualniSport, Long>{
	List<IndividualniSport> findAll();
}
