package application.ebuddy.dlithe.bootcamp.DLitheEbuddy.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.lang.Nullable;

@Entity
public class Event 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "eid")
	private Integer eventId;// event_id
	private String eventName;
	private Date eventStarted;
	private Date eventEnded;
	private String eventExpert;
	private String eventVenue;
	private Integer eventDuration;
	@Nullable
	private Integer eventParticipants;
	@Nullable
	private String eventStatus;
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Event(Integer eventId, String eventName, Date eventStarted, Date eventEnded, String eventExpert,
			String eventVenue, Integer eventDuration, Integer eventParticipants, String eventStatus) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventStarted = eventStarted;
		this.eventEnded = eventEnded;
		this.eventExpert = eventExpert;
		this.eventVenue = eventVenue;
		this.eventDuration = eventDuration;
		this.eventParticipants = eventParticipants;
		this.eventStatus = eventStatus;
	}
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", eventStarted=" + eventStarted
				+ ", eventEnded=" + eventEnded + ", eventExpert=" + eventExpert + ", eventVenue=" + eventVenue
				+ ", eventDuration=" + eventDuration + ", eventParticipants=" + eventParticipants + ", eventStatus="
				+ eventStatus + "]";
	}
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Date getEventStarted() {
		return eventStarted;
	}
	public void setEventStarted(Date eventStarted) {
		this.eventStarted = eventStarted;
	}
	public Date getEventEnded() {
		return eventEnded;
	}
	public void setEventEnded(Date eventEnded) {
		this.eventEnded = eventEnded;
	}
	public String getEventExpert() {
		return eventExpert;
	}
	public void setEventExpert(String eventExpert) {
		this.eventExpert = eventExpert;
	}
	public String getEventVenue() {
		return eventVenue;
	}
	public void setEventVenue(String eventVenue) {
		this.eventVenue = eventVenue;
	}
	public Integer getEventDuration() {
		return eventDuration;
	}
	public void setEventDuration(Integer eventDuration) {
		this.eventDuration = eventDuration;
	}
	public Integer getEventParticipants() {
		return eventParticipants;
	}
	public void setEventParticipants(Integer eventParticipants) {
		this.eventParticipants = eventParticipants;
	}
	public String getEventStatus() {
		return eventStatus;
	}
	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}
}
