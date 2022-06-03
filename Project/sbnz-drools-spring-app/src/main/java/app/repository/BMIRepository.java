package app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.BMI;

@Repository
public interface BMIRepository extends JpaRepository<BMI, Long> {

}


