package app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.RegisterDTO;
import app.exceptions.UserNotFoundExcpetion;
import app.model.Administrator;
import app.model.Notification;
import app.repository.NotificationRepository;

@Service
public class NotificationService {
	
	private NotificationRepository notificationRepository;
	
	@Autowired
	public NotificationService(NotificationRepository notificationRepository) {
		this.notificationRepository = notificationRepository;
	}

	public List<Notification> findByUserIdAndDateGreaterThan(Long userId) throws UserNotFoundExcpetion {
		

		LocalDate date_today = LocalDate.now();
		LocalTime midnight = LocalTime.of(0, 0, 0);
		
		LocalDateTime today = LocalDateTime.of(date_today, midnight);
				
		
		
		List<Notification> allNotifications=  this.notificationRepository.findByUserIdAndDateGreaterThan(userId, today);
		
		if(allNotifications == null) {
			throw new UserNotFoundExcpetion("Notifications for this user not found id: " + userId.toString());
		}
		
		return allNotifications;
	}
	
	public Notification create(Notification notification) {
		return this.notificationRepository.save(notification);
	}
}
