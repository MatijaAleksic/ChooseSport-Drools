package app.repository;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{
	List<Notification> findByUserIdAndDateGreaterThan(Long id, LocalDateTime date);
}


