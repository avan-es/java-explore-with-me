package ru.practicum.compilation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.compilation.model.Compilation;


@Repository(value = "dbComplicationRepository")
public interface CompilationRepository extends JpaRepository<Compilation, Long> {

}