package net.weg.wegproject.ConcreteClasses.user.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.address.model.entity.Address;
import net.weg.wegproject.ConcreteClasses.address.service.AddressService;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.Cart;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.CartProductQuantity;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
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
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    UserService userService;
    AddressService addressService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDTO objDTO) {
        try {
//            if (userService.verifyCPF(String.valueOf(objDTO.getRegister()))) {
            Cart cart = new Cart();
            cart.setTotalPrice(0f);
            cart.setSize(0);
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
    @GetMapping("/login")
    public ResponseEntity<Boolean> existsUserByEmailAndPassword(@RequestParam("email") String email,
                                                                @RequestParam("password") String password){
        try {
            System.out.print(email +"\n"+ password);
            return ResponseEntity.ok(userService.existsUserByEmailAndPassword(email, password));
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
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/address/{user_id}/{address_id}")
    public ResponseEntity<Address> removeAddress(@PathVariable Long user_id, @PathVariable Long address_id) {
        try {
            User user = userService.findOne(user_id);
            Address address = addressService.findOne(address_id);
            user.getAddress().remove(address);
            addressService.delete(address_id);
            userService.update(user);
            return ResponseEntity.ok(address);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
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
