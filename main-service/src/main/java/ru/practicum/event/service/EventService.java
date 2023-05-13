package ru.practicum.event.service;


import ru.practicum.event.dto.EventFullDto;
import ru.practicum.event.dto.NewEventDto;
import ru.practicum.event.dto.UpdateEventRequest;
import ru.practicum.event.enums.EventStateAction;
import ru.practicum.event.model.Event;
import ru.practicum.users.model.User;

import java.time.LocalDateTime;

public interface EventService {

    EventFullDto createEvent(Long userId, NewEventDto newEvent);

    EventFullDto updateEventByUser(Long userId, Long eventId, UpdateEventRequest updateEventByUser);

    Event updateEvent(Event updatedEvent, UpdateEventRequest updateEventRequest);
    void setEventStateByEventStateAction(Event event, EventStateAction eventStateAction);
    EventFullDto getFullEventById(Long userId, Long eventId);





    Event getEventById(Long eventId);
    void checkIfEvenDateCorrect(LocalDateTime evenDate);
    void checkIfEventCanBeUpdated(UpdateEventRequest updatedEven, Event oldEvent, User user);

}
