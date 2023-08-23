package net.weg.wegproject.ConcreteClasses.company.controller;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.company.exceptions.*;
import net.weg.wegproject.ConcreteClasses.company.model.dto.CompanyDTO;
import net.weg.wegproject.ConcreteClasses.company.model.entity.Company;
import net.weg.wegproject.ConcreteClasses.company.service.CompanyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@CrossOrigin
@RequestMapping("/company")
public class CompanyController{
    CompanyService companyService;

    @PostMapping
    public ResponseEntity<Company> create(@RequestBody CompanyDTO objDTO) {
        Company company = new Company();
        if (!CompanyService.verificarCNPJ(objDTO.getCNPJ())) {
            throw new CnpjException();
        }
        try {
            BeanUtils.copyProperties(objDTO, company);
            return ResponseEntity.ok(companyService.create(company));
        } catch (Exception e) {
            throw new CnpjException();
        }
    }
    @GetMapping
    public ResponseEntity<List<Company>> findAll() {
        try {
            return ResponseEntity.ok(companyService.findAll());
        } catch (Exception e) {
            throw new NoCompaniesException();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Company> findOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(companyService.findOne(id));
        } catch (Exception e) {
            throw new NoCompanyException();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Company> update(@RequestBody CompanyDTO objDTO, @PathVariable Long id) {
        try {
            try {
                Company company = companyService.findOne(id);
                BeanUtils.copyProperties(objDTO, company);
                return ResponseEntity.ok(companyService.update(company));
            } catch (BeansException e) {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            throw new CompanyUpdateException();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Company> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(companyService.delete(id));
        } catch (Exception e) {
            throw new CompanyDeleteException();
        }
    }
}
