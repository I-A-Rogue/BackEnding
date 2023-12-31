package net.weg.wegproject.ConcreteClasses.user.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.address.model.entity.Address;
import net.weg.wegproject.ConcreteClasses.address.repository.AddressRepository;
import net.weg.wegproject.ConcreteClasses.user.exceptions.*;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;
import net.weg.wegproject.ConcreteClasses.user.repository.UserRepository;
import net.weg.wegproject.interfaces.ServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements ServiceInterface<User> {
    UserRepository userRepository;
    AddressRepository addressRepository;

    @Override
    public User create(User obj) {
//        try {
            return userRepository.save(obj);
//        } catch (Exception e) {
//            throw new UserCreateException();
//        }
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
            return userRepository.findById(id).get();
        } catch (Exception e) {
            throw new NoUserException();
        }
    }

    public User findByEmail(String email){
        try {
            return userRepository.findByEmail(email);
        }catch (Exception e){
            throw new NoUserException();
        }
    }


    @Override
    public User update(User obj) {
        try {
            List<Address> addresses = new ArrayList<>();
            for (Address address:obj.getAddress()) {
                addresses.add(addressRepository.findById(address.getId()).get());
            }
            obj.setAddress(addresses);
            return userRepository.save(obj);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
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
