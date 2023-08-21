package net.weg.wegproject.interfaces;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ControllerInterface<T, S>{

    public ResponseEntity<T> create(S objDTO);
    public ResponseEntity<List<T>> findAll();
    public ResponseEntity<T> findOne(Long id);
    public ResponseEntity<T> update(S objDTO, Long id);
    public ResponseEntity<T> delete(Long id);
}
