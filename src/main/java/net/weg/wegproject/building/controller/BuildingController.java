package net.weg.wegproject.building.controller;

import lombok.AllArgsConstructor;
import net.weg.wegproject.building.model.dto.BuildingDTO;
import net.weg.wegproject.building.model.entity.Building;
import net.weg.wegproject.building.exceptions.BuildingCreateException;
import net.weg.wegproject.building.exceptions.NoBuildingsException;
import net.weg.wegproject.building.service.BuildingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/building")
public class BuildingController {
    BuildingService buildingService;

    @PostMapping
    public ResponseEntity<Building> create(@RequestBody BuildingDTO objDTO) {
        try {
            try {
                Building building = new Building();
                BeanUtils.copyProperties(objDTO, building);
                return ResponseEntity.ok(buildingService.create(building));
            } catch (BeansException e) {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            throw new BuildingCreateException();
        }
    }

    @GetMapping
    public ResponseEntity<List<Building>> findAll() {
        try {
            return ResponseEntity.ok(buildingService.findAll());
        } catch (Exception e) {
            throw new NoBuildingsException();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Building> findOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(buildingService.findOne(id));
        } catch (Exception e) {
            throw new NoBuildingsException();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Building> update(@RequestBody BuildingDTO objDTO, @PathVariable Long id) {
        try {
            try {
                Building building = buildingService.findOne(id);
                BeanUtils.copyProperties(objDTO, building);
                return ResponseEntity.ok(buildingService.update(building));
            } catch (BeansException e) {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            throw new BuildingCreateException();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Building> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(buildingService.delete(id));
        } catch (Exception e) {
            throw new NoBuildingsException();
        }
    }
}
