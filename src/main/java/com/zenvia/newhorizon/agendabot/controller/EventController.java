package com.zenvia.newhorizon.agendabot.controller;


import com.zenvia.newhorizon.agendabot.model.EventDto;
import com.zenvia.newhorizon.agendabot.service.EventService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


  @ApiOperation(value = "Get all events in calendar of this account ")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "successfully get all events "),
    @ApiResponse(code = 500, message = "an internal error occurred, it was not possible to complete this request")
  }
  )
    @GetMapping
    public ResponseEntity<Set<EventDto>> getEvents() throws IOException {
        return ResponseEntity.ok(eventService.getEvents().stream()
                .map(EventDto::new)
                .collect(Collectors.toSet()));
    }
}
