package ru.practicum.request.privatePart.dto;

import java.util.List;

//Изменение статуса запроса на участие в событии текущего пользователя
public class EventRequestStatusUpdateRequest {
    //Идентификаторы запросов на участие в событии текущего пользователя
    private List<Long> requestIds;
    //Новый статус запроса на участие в событии текущего пользователя
    //CONFIRMED, REJECTED
    private String status;
}
