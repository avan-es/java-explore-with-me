package ru.practicum.compilation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.compilation.dto.CompilationDto;
import ru.practicum.compilation.dto.NewCompilationDto;
import ru.practicum.compilation.service.CompilationService;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/admin/compilations")
@RequiredArgsConstructor
public class CompilationAdminController {

    private final CompilationService compilationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompilationDto createEvent(
            @Valid @RequestBody NewCompilationDto newCompilation) {
        return compilationService.createCompilation(newCompilation);
    }


    /*
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventFullDto createEvent(
            @Positive @PathVariable Long userId,
            @Valid @RequestBody NewEventDto newEvent) {
        return eventService.createEvent(userId, newEvent);
    }

    @PatchMapping("/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    public EventFullDto updateEventByUser(
            @Positive @PathVariable Long userId,
            @Positive @PathVariable Long eventId,
            @Valid @RequestBody UpdateEventRequest updatedEventByUser) {
        return eventService.updateEvent(userId, eventId, updatedEventByUser, false, true);
    }

    @GetMapping("/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    public EventFullDto getFullEventById(
            @Positive @PathVariable Long userId,
            @Positive @PathVariable Long eventId) {
        return eventService.getFullEventById(userId, eventId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EventShortDto> getAllUsersEvents(
            @Positive @PathVariable Long userId,
            @PositiveOrZero @RequestParam(value = "from", defaultValue = "0") Integer from,
            @Positive @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return eventService.getAllUsersEvents(from, size, userId);
    }

    @GetMapping("/{eventId}/requests")
    @ResponseStatus(HttpStatus.OK)
    public List<ParticipationRequestDto> getRequestsOnEvent(
            @Positive @PathVariable Long userId,
            @Positive @PathVariable Long eventId) {
        return eventService.getRequestsOnEvent(userId, eventId);
    }

    @PatchMapping("/{eventId}/requests")
    @ResponseStatus(HttpStatus.OK)
    public EventRequestStatusUpdateResult processWithEventsRequests(
            @Valid @RequestBody EventRequestStatusUpdateRequest requests,
            @Positive @PathVariable Long userId,
            @Positive @PathVariable Long eventId) {
        return eventService.processWithEventsRequests(userId, eventId, requests);
    }

     */

}
