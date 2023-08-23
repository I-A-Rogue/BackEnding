package net.weg.wegproject.ink.repository;

import net.weg.wegproject.ConcreteClasses.productsClasses.ink.model.Ink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InkRepository extends JpaRepository<Ink, Long> {
}