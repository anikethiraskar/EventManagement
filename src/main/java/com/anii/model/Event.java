
package com.anii.model;

import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "type")
    private String type;
    @Column(name = "event_date")
    private String date;
    @Column(name = "venue")
    private String venue;
    @Column(name = "description")
    private String description;
    @Column(name = "registrationLink")
    private String registrationLink;
	public Event(int id, String title, String type, String date, String venue, String description,
			String registrationLink) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.date = date;
		this.venue = venue;
		this.description = description;
		this.registrationLink = registrationLink;
	}
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegistrationLink() {
		return registrationLink;
	}
	public void setRegistrationLink(String registrationLink) {
		this.registrationLink = registrationLink;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", type=" + type + ", date=" + date + ", venue=" + venue
				+ ", description=" + description + ", registrationLink=" + registrationLink + "]";
	}

    // getters and setters
    
}
