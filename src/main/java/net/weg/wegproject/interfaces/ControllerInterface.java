package net.weg.wegproject.interfaces;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ControllerInterface<T, S>{

    ResponseEntity<T> create(S objDTO);
    ResponseEntity<List<T>> findAll();
    ResponseEntity<T> findOne(Long id);
    ResponseEntity<T> update(S objDTO, Long id);
    ResponseEntity<T> delete(Long id);
}
