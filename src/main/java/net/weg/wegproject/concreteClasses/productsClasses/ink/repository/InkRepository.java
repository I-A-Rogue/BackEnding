package net.weg.wegproject.concreteClasses.productsClasses.ink.repository;

<<<<<<< Updated upstream:src/main/java/net/weg/wegproject/ink/repository/InkRepository.java
import net.weg.wegproject.ink.model.Ink;
=======
import net.weg.wegproject.concreteClasses.productsClasses.ink.model.Ink;
>>>>>>> Stashed changes:src/main/java/net/weg/wegproject/concreteClasses/productsClasses/ink/repository/InkRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InkRepository extends JpaRepository<Ink, Long> {
}
