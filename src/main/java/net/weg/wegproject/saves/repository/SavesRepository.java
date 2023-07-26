package net.weg.wegproject.saves.repository;

import net.weg.wegproject.saves.model.Saves;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavesRepository extends JpaRepository<Saves, Long> {
}
