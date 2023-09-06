package net.weg.wegproject.ConcreteClasses.saves.controller;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.cart.exceptions.ExistingProductException;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.Cart;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.service.ProductService;
import net.weg.wegproject.ConcreteClasses.saves.exceptions.NoProductsSavedException;
import net.weg.wegproject.ConcreteClasses.saves.exceptions.ProductNotSavedException;
import net.weg.wegproject.ConcreteClasses.saves.model.dto.SavesDTO;
import net.weg.wegproject.ConcreteClasses.saves.model.entity.Saves;
import net.weg.wegproject.ConcreteClasses.saves.service.SavesService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/saves")
public class SavesController{

    SavesService savesService;
    ProductService productService;

    @PutMapping("/add/{savesId}/{productCode}")
    public ResponseEntity<?> addOnSaves(@PathVariable Long savesId, @PathVariable Long productCode) {
        Saves saves = findOne(savesId).getBody();
        Product product = productService.findByCode(productCode);
        if (saves != null) {
            saves.setQuantity(saves.getQuantity() + 1);
            try{
                if(!saves.getProducts().contains(product)) {
                    saves.getProducts().add(product);
                } else {
                    throw new ExistingProductException();
                }
            }catch (ExistingProductException e){
                throw new RuntimeException(e.getMessage());
            }
        }
        return ResponseEntity.ok(savesService.update(saves));
    }

    @GetMapping
    public ResponseEntity<List<Saves>> findAll() {
        try {
            return ResponseEntity.ok(savesService.findAll());
        }catch (Exception e){
            throw new NoProductsSavedException();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Saves> findOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(savesService.findOne(id));
        }catch (Exception e){
            throw new ProductNotSavedException();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Saves> update(@RequestBody SavesDTO objDTO, @PathVariable Long id) {
        Saves obj = new Saves();
        BeanUtils.copyProperties(objDTO, obj);
        return ResponseEntity.ok(savesService.update(obj));
    }

    @PutMapping("/remove/{savesId}/{productCode}")
    public ResponseEntity<Saves> removeFromSaves(@PathVariable Long savesId, @PathVariable Long productCode) {
        Saves saves = findOne(savesId).getBody();
        Product product = productService.findByCode(productCode);
        try {
            if (saves != null && saves.getQuantity() > 0) {
                if(saves.getProducts().contains(product)) {
                    saves.setQuantity(saves.getQuantity() - 1);
                    saves.getProducts().remove(product);
                }else{
                    throw new ProductNotSavedException();
                }
            } else {
                throw new NoProductsSavedException();
            }
        } catch (NoProductsSavedException | ProductNotSavedException e) {
            throw new RuntimeException(e.getMessage());
        }

        return ResponseEntity.ok(savesService.update(saves));
    }
}
