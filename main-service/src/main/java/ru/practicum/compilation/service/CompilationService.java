package ru.practicum.compilation.service;


import ru.practicum.compilation.dto.CompilationDto;
import ru.practicum.compilation.dto.NewCompilationDto;
import ru.practicum.compilation.dto.UpdateCompilationRequest;
import ru.practicum.compilation.model.Compilation;

public interface CompilationService {

    CompilationDto createCompilation(NewCompilationDto newCompilation);

    CompilationDto updateCompilationById(Long compId, UpdateCompilationRequest updatedCompilation);

    Compilation getCompilationById(Long compId);
}
