package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Sport;
import app.model.TimskiSport;

@Repository
public interface TimskiSportRepository extends JpaRepository<TimskiSport, Long>{
	List<TimskiSport> findAll();

}
