package telran.ashkelon2018.mishpahug.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.ashkelon2018.mishpahug.dto.NotificationDto;
import telran.ashkelon2018.mishpahug.service.NotificationService;

@RestController
@RequestMapping("/notification")
public class NotificationController {
	
	@Autowired
	NotificationService notificationService;
	
	@GetMapping("/list")
	Iterable<NotificationDto> findNotifications(@RequestHeader("Authorization") String token) {
		return notificationService.findNotifications(token);
	}

	@PutMapping("/isRead/{notificationId}")
	boolean notificationIsRead(@PathVariable Long notificationId,@RequestHeader("Authorization") String token) {
		return notificationService.notificationIsRead(notificationId, token);
	}

	@GetMapping("/count")
	public Integer countUnreadNotifications(@RequestHeader("Authorization") String token) {
		return notificationService.countUnreadNotifications(token);
	}
	
	@GetMapping("/message")
	public String textMessage() {
		return "Hello World";
	}
	
	@GetMapping("/message")
	public String textMessage() {
		return "Hello World";
	}
	@GetMapping("/message")
	public String textMessage() {
		return "Hello World";
	}
	@GetMapping("/message")
	public String textMessage() {
		return "Hello World";
	}
	

}
