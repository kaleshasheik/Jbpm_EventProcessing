package com.aricent.rest.jersey;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Event")
public class Event {


	
	 private String eventId;
	 private int temperature;
	 private String timestamp;


	// Must have no-argument constructor
	public Event() {

	}

	public Event(String eventId, int temperature, String timestamp) {
		this.eventId = eventId;
		this.temperature =temperature;
		this.timestamp =timestamp;
	}

	@XmlElement
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventId() {
		return this.eventId;
	}

	@XmlElement
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getTemperature() {
		return this.temperature;
	}

	@XmlElement
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getTimestamp() {
		return this.timestamp;
	}

	@Override
	public String toString() {
		return new StringBuffer(" Event Id : ").append(this.eventId)
				.append(" Temperature : ").append(this.temperature).append(" Timestamp : ").append(this.timestamp)
				.toString();
	}

}