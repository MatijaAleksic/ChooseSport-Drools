package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.exceptions.UserNotFoundExcpetion;
import app.model.Notification;
import app.repository.NotificationRepository;

@Service
public class NotificationService {
	
	private NotificationRepository notificationRepository;
	
	@Autowired
	public NotificationService(NotificationRepository notificationRepository) {
		this.notificationRepository = notificationRepository;
	}

	public List<Notification> findByUserId(Long userId) throws UserNotFoundExcpetion {
		List<Notification> allNotifications=  this.notificationRepository.findByUserId(userId);
		
		if(allNotifications == null) {
			throw new UserNotFoundExcpetion("Notifications for this user not found id: " + userId.toString());
		}
		
		return allNotifications;
	}
}
