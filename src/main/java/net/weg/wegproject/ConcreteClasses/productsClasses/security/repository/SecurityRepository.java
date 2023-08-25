package net.weg.wegproject.ConcreteClasses.productsClasses.security.repository;

import net.weg.wegproject.ConcreteClasses.productsClasses.security.model.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Long> {
}
