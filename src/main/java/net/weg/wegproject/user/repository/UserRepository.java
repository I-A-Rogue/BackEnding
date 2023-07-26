package net.weg.wegproject.user.repository;

import net.weg.wegproject.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    boolean existsUserByEmailAndPassword(String email, String password);
}
