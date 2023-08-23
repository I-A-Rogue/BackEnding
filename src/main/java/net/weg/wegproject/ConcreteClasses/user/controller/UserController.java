package net.weg.wegproject.ConcreteClasses.user.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.Cart;
import net.weg.wegproject.ConcreteClasses.saves.model.entity.Saves;
import net.weg.wegproject.ConcreteClasses.user.exceptions.*;
import net.weg.wegproject.ConcreteClasses.user.model.dto.UserDTO;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;
import net.weg.wegproject.ConcreteClasses.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDTO objDTO) {
        try {
//            if (userService.verifyCPF(String.valueOf(objDTO.getRegister()))) {
            Cart cart = new Cart();
            cart.setTotalPrice(0f);
            cart.setSize(0);
            cart.setProducts(new ArrayList<>());
            Saves saves = new Saves();
            saves.setQuantity(0);
            saves.setProducts(new ArrayList<>());
            User user = new User();
            BeanUtils.copyProperties(objDTO, user);
            user.setCart(cart);
            user.setSaves(saves);
            return ResponseEntity.ok(userService.create(user));
//            } else {
//                throw new InvalidCpfException();
//            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        try {
            return ResponseEntity.ok(userService.findAll());
        } catch (Exception e) {
            throw new NoUsersException();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.findOne(id));
        } catch (Exception e) {
            throw new NoUserException();
        }
    }
    @GetMapping("/email/{email}")
    public void findByEmail(@PathVariable String email){
        try {
            ResponseEntity.ok(userService.findByEmail(email));
        }catch (Exception e){
            throw new NoUserException();
        }
    }
    @GetMapping("/{email}/{password}")
    public void existsUserByEmailAndPassword(@PathVariable String email, @PathVariable String password){
        try {
            ResponseEntity.ok(userService.existsUserByEmailAndPassword(email, password));
        }catch (Exception e){
            throw new NoUserException();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody UserDTO objDTO, @PathVariable Long id) {
        try {
            User user = userService.findOne(id);
            BeanUtils.copyProperties(objDTO, user);
            return ResponseEntity.ok(userService.update(user));
        } catch (Exception e) {
            throw new UserUpdateException();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.delete(id));
        } catch (Exception e) {
            throw new UserDeleteException();
        }
    }
}
