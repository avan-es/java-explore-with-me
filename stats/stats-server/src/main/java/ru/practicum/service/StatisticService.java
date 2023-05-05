package ru.practicum.service;

import ru.practicum.dto.StatisticGetDto;
import ru.practicum.dto.StatisticPostDto;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface StatisticService {
    List<StatisticGetDto> getStatistic(String path, Map<String, String> params, Set<String> uris);

    StatisticPostDto addStatistic(StatisticPostDto statisticPostDto);
}
