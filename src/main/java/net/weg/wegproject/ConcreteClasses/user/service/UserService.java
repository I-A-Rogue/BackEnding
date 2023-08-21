package net.weg.wegproject.ConcreteClasses.user.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.user.exceptions.*;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;
import net.weg.wegproject.ConcreteClasses.user.repository.UserRepository;
import net.weg.wegproject.interfeces.ServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements ServiceInterface<User> {
    UserRepository userRepository;

    @Override
    public User create(User obj) {
        try {
            return userRepository.save(obj);
        } catch (Exception e) {
            throw new UserCreateException();
        }
    }

    @Override
    public List<User> findAll() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new NoUsersException();
        }
    }

    @Override
    public User findOne(Long id) {
        try {
            return userRepository.findById(id).orElseThrow();
        } catch (Exception e) {
            throw new NoUserException();
        }
    }

    public boolean findByEmail(String email){
        try {
            return userRepository.existsByEmail(email);
        }catch (Exception e){
            throw new NoUserException();
        }
    }

    public boolean existsUserByEmailAndPassword(String email, String password){
        try {
            return userRepository.existsUserByEmailAndPassword(email, password);
        }catch (Exception e){
            throw new NoUserException();
        }
    }

    @Override
    public User update(User obj) {
        try {
            return userRepository.save(obj);
        } catch (Exception e) {
            throw new UserUpdateException();
        }
    }

    @Override
    public User delete(Long id) {
        try {
            User user = findOne(id);
            userRepository.deleteById(id);
            return user;
        } catch (Exception e) {
            throw new UserDeleteException();
        }
    }

    public boolean verifyCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 > 9) {
            digito1 = 0;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 > 9) {
            digito2 = 0;
        }

        return (cpf.charAt(9) - '0' == digito1) && (cpf.charAt(10) - '0' == digito2);
    }
}
