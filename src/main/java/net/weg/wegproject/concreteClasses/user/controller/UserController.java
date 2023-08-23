package net.weg.wegproject.concreteClasses.user.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.weg.wegproject.concreteClasses.user.exceptions.*;
import net.weg.wegproject.concreteClasses.user.model.dto.UserDTO;
import net.weg.wegproject.concreteClasses.user.model.entity.User;
import net.weg.wegproject.concreteClasses.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDTO objDTO) {
        try {
                User user = new User();
                System.out.print(objDTO);
                BeanUtils.copyProperties(objDTO, user);
                return ResponseEntity.ok(userService.create(user));
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
//    @GetMapping("/{id}")
//    public ResponseEntity<User> findOne(@RequestBody Long id) {
//        try {
//            return ResponseEntity.ok(userService.findOne(id));
//        } catch (Exception e) {
//            throw new NoUserException();
//        }
//    }
    @GetMapping("/{email}")
    public void findByEmail(@Param("email") String email){
        try {
            ResponseEntity.ok(userService.findByEmail(email));
        }catch (Exception e){
            throw new NoUserException();
        }
    }
    @GetMapping("/login")
    public ResponseEntity<Boolean> existsUserByEmailAndPassword(@RequestParam("email") String email,
                                             @RequestParam("password") String password){
        try {
            System.out.print(email + " " + password + "\n");
            return ResponseEntity.ok(userService.existsUserByEmailAndPassword(email, password));
        }catch (Exception e){
            throw new NoUserException();
        }
    }
    @PatchMapping("/{id}")
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
