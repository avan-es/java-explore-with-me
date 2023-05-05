package ru.practicum.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.dto.StatisticGetDto;
import ru.practicum.dto.StatisticPostDto;
import ru.practicum.model.StatisticMapper;
import ru.practicum.repository.StatisticRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final StatisticRepository statisticRepository;

    @Override
    public List<StatisticGetDto> getStatistic(String path, Map<String, String> params, Set<String> uris) {
        boolean isUnique = false;
        if (params.containsKey("unique")) {
            isUnique = Boolean.parseBoolean(params.get("unique"));
        }
        if (uris == null && !isUnique) {
            return statisticRepository.getUrisViews(stringToLocalDate(params.get("start")),
                    stringToLocalDate(params.get("end")));
        } else if (uris == null && isUnique) {
            return statisticRepository.getUrisViewsUnique(stringToLocalDate(params.get("start")),
                    stringToLocalDate(params.get("end")));
        }

        if (!isUnique) {
            return statisticRepository.getUriViews(uris, stringToLocalDate(params.get("start")),
                    stringToLocalDate(params.get("end")));
        } else {
            return statisticRepository.getUriViewsUnique(uris, stringToLocalDate(params.get("start")),
                    stringToLocalDate(params.get("end")));
        }
//        if (uris == null && !isUnique) {
//            return statisticRepository.getUrisViews(stringToLocalDate(params.get("start")),
//                    stringToLocalDate(params.get("end")));
//        } else if (uris == null && isUnique) {
//            return statisticRepository.getUrisViewsUnique(stringToLocalDate(params.get("start")),
//                    stringToLocalDate(params.get("end")));
//        } else if (!uris.isEmpty() && !isUnique) {
//            return statisticRepository.getUriViews(uris, stringToLocalDate(params.get("start")),
//                    stringToLocalDate(params.get("end")));
//        } else {
//            return statisticRepository.getUriViewsUnique(uris, stringToLocalDate(params.get("start")),
//                    stringToLocalDate(params.get("end")));
//        }
    }

    @Override
    public StatisticPostDto addStatistic(StatisticPostDto statisticPostDto) {
        statisticRepository.save(StatisticMapper.INSTANT.toStatistic(statisticPostDto));
        return statisticPostDto;
    }

    private LocalDateTime stringToLocalDate(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
