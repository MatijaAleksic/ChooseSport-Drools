package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.UserIdDTO;
import app.model.Notification;
import app.service.NotificationService;

@RestController
@RequestMapping(value = "/notifications", consumes="application/json")
public class NotificationsController {
	
	private NotificationService notificationService;

	@Autowired
	public NotificationsController(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
	
	@PostMapping(produces = "application/json")
	public ResponseEntity<?> getNotificationsForUser(@RequestBody UserIdDTO dto) throws Exception {

		List<Notification> notifikacije = this.notificationService.findByUserId(dto.getId());
		
		if(notifikacije == null) {
			return new ResponseEntity<>("No notifications found for user!",  HttpStatus.NOT_FOUND);
		}
			
		return new ResponseEntity<>(notifikacije, HttpStatus.OK);
				
	}

}
