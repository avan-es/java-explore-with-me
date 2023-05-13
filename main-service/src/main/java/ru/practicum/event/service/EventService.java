package ru.practicum.event.service;


import ru.practicum.event.dto.EventFullDto;
import ru.practicum.event.dto.NewEventDto;

public interface EventService {

    EventFullDto createEvent(Long userId, NewEventDto newEvent);
}
