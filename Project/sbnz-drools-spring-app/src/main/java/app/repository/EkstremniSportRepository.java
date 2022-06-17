package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import app.model.EkstremniSport;

public interface EkstremniSportRepository extends JpaRepository<EkstremniSport, Long>{
	List<EkstremniSport> findAll();
}
