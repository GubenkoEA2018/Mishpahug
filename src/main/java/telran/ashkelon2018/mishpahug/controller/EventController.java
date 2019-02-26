package telran.ashkelon2018.mishpahug.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import telran.ashkelon2018.mishpahug.domain.Event;
import telran.ashkelon2018.mishpahug.dto.EventDone;
import telran.ashkelon2018.mishpahug.dto.EventInProgressOrPendingDto;
import telran.ashkelon2018.mishpahug.dto.FullEventInPOrPDto;
import telran.ashkelon2018.mishpahug.dto.NewEventDto;
import telran.ashkelon2018.mishpahug.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	EventService eventService;
	
	@PostMapping("/allprogresslist/{page}/{size}")
	Iterable<Event> findEventsInProgress(@RequestBody List<String> tags, @RequestParam int page, @RequestParam int size){
		return eventService.findEventsInProgress(tags, page, size);
	}
	
	@PostMapping("/creation")
	Event addEvent(@RequestBody NewEventDto newEventDto, @RequestHeader("Authorization") String token) {
		return eventService.addEvent(newEventDto, token);
	}
	
	@GetMapping("/calendar/{month}")
	Iterable<Event> findEventsForCalendar(@PathVariable Integer month, @RequestHeader("Authorization") String token){
		return eventService.findEventsForCalendar(month, token);
	}
	
	@GetMapping("/own/{eventId}")
	FullEventInPOrPDto getEvent(@PathVariable Long eventId, @RequestHeader("Authorization") String token) {
		return eventService.getEvent(eventId, token);
	}
	
	@GetMapping("/subscribed/{eventId}")
	EventInProgressOrPendingDto findEventsSubscribed(@PathVariable Long eventId, @RequestHeader("Authorization") String token) {
		return eventService.findEventsSubscribed(eventId, token);
	} 
	
	//Iterable<NotificationDto> findNotifications(String token);
	
	@GetMapping("/currentlist")
	Iterable<FullEventInPOrPDto> findMyEventList(@RequestHeader("Authorization") String token){
		return eventService.findMyEventList(token);
	}
	
	@GetMapping("/historylist")
	Iterable<EventDone> fintMyEventsHistory(@RequestHeader("Authorization") String token){
		return eventService.fintMyEventsHistory(token);
	}
	
	@GetMapping("/participationlist")
	Iterable<Event> findParticipationList(@RequestHeader("Authorization") String token){
		return eventService.findParticipationList(token);
	}
	
	@PutMapping("/subscription/{eventId}")
	boolean subscribeToEvent(@PathVariable Long eventId, @RequestHeader("Authorization") String token) {
		return eventService.subscribeToEvent(eventId, token);
	}
	
	@PutMapping("/unsubscription/{eventId}")
	boolean unsubscribeFromEvent(@PathVariable Long eventId, @RequestHeader("Authorization") String token) {
		return eventService.unsubscribeFromEvent(eventId, token);
	}
	
	@PutMapping("/vote/{eventId}/{voteCount}")
	boolean voteForEvent(@PathVariable Long eventId, @PathVariable Double voteCount, @RequestHeader("Authorization") String token) {
		return eventService.voteForEvent(eventId, voteCount, token);
	}
	
	@PutMapping("/invitation/{eventId}/{userId}")
	boolean inviteToEvent(@PathVariable Long eventId, @PathVariable Long userId, @RequestHeader("Authorization") String token){
		return eventService.inviteToEvent(eventId, userId, token);
	}
	
	@PutMapping("/pending/{eventId}")
	boolean changeEventStatus (@PathVariable Long eventId, @RequestHeader("Authorization") String token){
		return eventService.changeEventStatus(eventId, token);
	}
	
	//boolean notificationIsRead(Long notificationId, String token);
	
	//Integer countUnreadNotifications(String token);

	
	
	
	
	
}
