package ru.practicum.request.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.request.model.Request;

import java.util.List;


@Repository(value = "dbRequestRepository")
public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findAllByRequesterId (Long userId);

}
