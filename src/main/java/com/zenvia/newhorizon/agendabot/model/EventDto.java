package com.zenvia.newhorizon.agendabot.model;


import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;

import java.util.List;

public class EventDto {

    private String id;
    private DateTime created;
    private String creator;
    private String location;
    private EventDateTime start;
    private EventDateTime end;
    private List<EventAttendee> attendees;
    private String status;

    public EventDto(Event event) {
        this.id = event.getId();
        this.created = event.getCreated();
        this.creator = event.getCreator().getEmail();
        this.location = event.getLocation();
        this.start = event.getStart();
        this.end = event.getEnd();
        this.attendees = event.getAttendees();
        this.status = event.getStatus();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DateTime getCreated() {
        return created;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public EventDateTime getStart() {
        return start;
    }

    public void setStart(EventDateTime start) {
        this.start = start;
    }

    public EventDateTime getEnd() {
        return end;
    }

    public void setEnd(EventDateTime end) {
        this.end = end;
    }

    public List<EventAttendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<EventAttendee> attendees) {
        this.attendees = attendees;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
