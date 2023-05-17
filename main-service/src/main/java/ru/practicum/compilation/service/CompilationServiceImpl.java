package ru.practicum.compilation.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.category.dto.CategoryDto;
import ru.practicum.category.model.CategoryMapper;
import ru.practicum.compilation.dto.CompilationDto;
import ru.practicum.compilation.dto.NewCompilationDto;
import ru.practicum.compilation.model.Compilation;
import ru.practicum.compilation.model.CompilationMapper;
import ru.practicum.compilation.repository.CompilationRepository;
import ru.practicum.event.model.Event;
import ru.practicum.event.model.EventMapper;
import ru.practicum.event.service.EventService;
import ru.practicum.users.model.User;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompilationServiceImpl implements CompilationService {

    private final CompilationRepository compilationRepository;

    private final EventService eventService;


    @Override
    @Transactional
    public CompilationDto createCompilation(NewCompilationDto newCompilation) {
        log.info("Администратор создает новую подборку \"{}\".", newCompilation.getTitle());
        //checkIfEvensExists(newCompilation.getEvents());
        List<Event> events = eventService.getEventByIds(newCompilation.getEvents());
        Compilation compilation = compilationRepository.save(CompilationMapper.INSTANT.toCompilation(newCompilation, events));
        log.debug("Администратор создал новую подборку \"{}\" с ID = {}.", compilation.getTitle(), compilation.getId());
        return CompilationMapper.INSTANT.toCompilationDto(compilation);
    }

    private void checkIfEvensExists(List<Long> events) {
    }
}
