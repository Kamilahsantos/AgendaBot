package com.zenvia.newhorizon.agendabot.service;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EventService {

    private final Calendar calendar;

    public EventService(Calendar calendar) {
        this.calendar = calendar;
    }


    public List<Event> getEvents() throws IOException {
        DateTime now = new DateTime(System.currentTimeMillis());

        Events events = calendar.events().list("primary")
                .setMaxResults(10)
                .setTimeMin(now)
                .setOrderBy("startTime")
                .setSingleEvents(true)
                .execute();
      List<Event> items = events.getItems();
      if (items.isEmpty()) {
        System.out.println("Nao há nenhum evento agendado");
      } else {
        System.out.println("Próximos eventos");
        for (Event event : items) {
          DateTime start = event.getStart().getDateTime();
          if (start == null) {
            start = event.getStart().getDate();
          }
          System.out.printf("%s (%s)\n", event.getSummary(), start);
        }

    }

      return events.getItems();

} }
