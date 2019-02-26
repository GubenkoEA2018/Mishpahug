package telran.ashkelon2018.mishpahug.service;

import java.util.List;

import org.springframework.stereotype.Service;

import telran.ashkelon2018.mishpahug.domain.Event;
import telran.ashkelon2018.mishpahug.dto.EventDone;
import telran.ashkelon2018.mishpahug.dto.EventInProgressOrPendingDto;
import telran.ashkelon2018.mishpahug.dto.FullEventInPOrPDto;
import telran.ashkelon2018.mishpahug.dto.NewEventDto;

@Service
public class EventServiceImpl implements EventService {

	@Override
	public Iterable<Event> findEventsInProgress(List<String> tags, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event addEvent(NewEventDto newEventDto, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Event> findEventsForCalendar(Integer month, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FullEventInPOrPDto getEvent(Long eventId, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventInProgressOrPendingDto findEventsSubscribed(Long eventId, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<FullEventInPOrPDto> findMyEventList(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<EventDone> fintMyEventsHistory(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Event> findParticipationList(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean subscribeToEvent(Long eventId, String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unsubscribeFromEvent(Long eventId, String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean voteForEvent(Long eventId, Double voteCount, String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inviteToEvent(Long eventId, Long userId, String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeEventStatus(Long eventId, String token) {
		// TODO Auto-generated method stub
		return false;
	}

}
