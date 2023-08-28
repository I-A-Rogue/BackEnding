package net.weg.wegproject.ConcreteClasses.productsClasses.product.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Filtro;
import net.weg.wegproject.enums.CategoriesEnums;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.repository.ProductRepository;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ProductService{
    ProductRepository productRepository;

    public Product create(Product obj) {
        return productRepository.save(obj);
    }

    public Page<Product> findAllByCategories(Pageable pageable, CategoriesEnums categories){
        return productRepository.findAllByCategories(pageable, categories);
    }

    public List<Product> filterProducts(String search, Pageable pageable, Filtro filtro) {
        // Passo 1: Obter a lista de produtos base usando a filtragem global
        List<Product> prods = productRepository.filterProducts(pageable, search, filtro.getPriceMin(), filtro.getPriceMax());

        // Passo 2 e 3: Aplicar filtros específicos da categoria na lista de produtos base
        List<Product> filteredProds = new ArrayList<>(prods); // Nova lista para armazenar produtos filtrados

        if (CategoriesEnums.INK.name().equals(filtro.getCategories().toUpperCase())) {
            filteredProds.retainAll(productRepository.filterInk(
                    pageable,
                    filtro.getColor(),
                    filtro.getDensity()
            ));
        } else if (CategoriesEnums.MOTORS.name().equals(filtro.getCategories().toUpperCase())) {
            filteredProds.retainAll(productRepository.filterMotors(
                    pageable,
                    filtro.getFrequencyMin(),
                    filtro.getFrequencyMax(),
                    filtro.getCarcass(),
                    filtro.getMaterial()
            ));
        } else if (CategoriesEnums.AUTOMATION.name().equals(filtro.getCategories().toUpperCase())) {
            filteredProds.retainAll(productRepository.filterAutomation(
                    pageable,
                    filtro.getVoltage(),
                    filtro.getRfi(),
                    filtro.getTemperature()
            ));
        } else if (CategoriesEnums.SECURITY.name().equals(filtro.getCategories().toUpperCase())) {
            filteredProds.retainAll(productRepository.filterSecurity(
                    pageable,
                    filtro.getFrequencyMin(),
                    filtro.getFrequencyMax(),
                    filtro.getVoltage()
            ));
        } else if (CategoriesEnums.BUILDING.name().equals(filtro.getCategories().toUpperCase())) {
            filteredProds.retainAll(productRepository.filterBuilding(
                    pageable,
                    filtro.getPlug(),
                    filtro.getBattery(),
                    filtro.getCasing()
            ));
        }

        return filteredProds; // Retorna a lista de produtos filtrados pela categoria
    }

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findByCode(Long code) {
        try {
            return productRepository.findByCode(code);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Produto inexistente");
        }
    }

    public Product update(Product obj) {
        return productRepository.save(obj);
    }

    public Product delete(Long id) {
        Product product = findByCode(id);
        productRepository.delete(product);
        return product;
    }
}
