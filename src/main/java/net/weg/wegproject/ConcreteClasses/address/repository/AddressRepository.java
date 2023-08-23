package net.weg.wegproject.ConcreteClasses.address.repository;

import net.weg.wegproject.ConcreteClasses.address.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
