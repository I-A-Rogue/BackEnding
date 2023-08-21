package net.weg.wegproject.concreteClasses.company.repository;

import net.weg.wegproject.concreteClasses.company.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
