package net.weg.wegproject.concreteClasses.user.repository;

import net.weg.wegproject.concreteClasses.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    Boolean existsUserByEmailAndPassword(String email, String password);
}
