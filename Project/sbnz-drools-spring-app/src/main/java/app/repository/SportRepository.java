package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Sport;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long>{

	List<Sport> findAll();

}
