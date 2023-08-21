package net.weg.wegproject.concreteClasses.saves.controller;

import net.weg.wegproject.concreteClasses.saves.model.entity.Saves;
import net.weg.wegproject.concreteClasses.saves.model.dto.SavesDTO;
import net.weg.wegproject.concreteClasses.saves.service.SavesService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/saves")
public class SavesController{
    SavesService savesService;

    @PostMapping
    public ResponseEntity<Saves> create(@RequestBody SavesDTO objDTO) {
        Saves obj = new Saves();
        BeanUtils.copyProperties(objDTO, obj);
        return ResponseEntity.ok(savesService.create(obj));
    }

    @GetMapping
    public ResponseEntity<List<Saves>> findAll() {
        return ResponseEntity.ok(savesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Saves> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(savesService.findOne(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Saves> update(@RequestBody SavesDTO objDTO, @PathVariable Long id) {
        Saves obj = new Saves();
        BeanUtils.copyProperties(objDTO, obj);
        return ResponseEntity.ok(savesService.update(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Saves> delete(@PathVariable Long id) {
        return ResponseEntity.ok(savesService.delete(id));
    }
}
