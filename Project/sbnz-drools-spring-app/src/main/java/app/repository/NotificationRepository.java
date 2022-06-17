package app.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{
	List<Notification> findByUserId(Long id);
}


