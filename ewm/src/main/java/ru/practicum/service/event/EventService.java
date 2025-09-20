package ru.practicum.service.event;

import ru.practicum.dto.event.*;
import ru.practicum.dto.request.ParticipationRequestDto;

import java.util.List;

public interface EventService {
    List<EventShortDto> findPublicEvents(EventPublicParam params);

    EventFullDto findPublicEventById(Long eventId);

    List<EventShortDto> findUserEvents(Long userId, EventPrivateParam params);

    EventFullDto createEvent(Long userId, NewEventDto dto);

    EventFullDto findUserEventById(Long eventId, Long userId);

    EventFullDto updateUserEvent(UpdateEventUserRequestParam requestParam);

    List<ParticipationRequestDto> findEventRequests(Long eventId, Long userId);

    EventRequestStatusUpdateResult updateRequestStatus(EventRequestStatusUpdateRequestParam requestParam);
}
