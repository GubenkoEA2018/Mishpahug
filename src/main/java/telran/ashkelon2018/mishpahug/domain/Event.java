package telran.ashkelon2018.mishpahug.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Event")
public class Event {
	Long eventId;
	String title;
	String holiday;
	Address address;
	String confession;
	LocalDate date;//":"[yyyy-MM-dd]",
	LocalTime time;//":"[HH:mm:ss]",
	Integer duration;
	String[] food;
	String description;
		}


