package net.weg.wegproject.ConcreteClasses.saves.repository;

import net.weg.wegproject.ConcreteClasses.saves.model.entity.Saves;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavesRepository extends JpaRepository<Saves, Long> {
}
