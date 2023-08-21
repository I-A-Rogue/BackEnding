package net.weg.wegproject.concreteClasses.saves.repository;

import net.weg.wegproject.concreteClasses.saves.model.entity.Saves;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavesRepository extends JpaRepository<Saves, Long> {
}
