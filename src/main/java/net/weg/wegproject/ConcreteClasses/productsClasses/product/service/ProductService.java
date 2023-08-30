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


    public Page<Product> searchBy(Pageable pageable, String searchTerm){
        return productRepository.search(pageable, searchTerm);
    }

    //Filtros

    public Page<Product> buscarCategoriaMotor(Pageable pageable, Filtro filtro){
        return productRepository.filterMotors(pageable,
                filtro.getPriceMin(),
                filtro.getPriceMax(),
                filtro.getFrequencyMin(),
                filtro.getFrequencyMax(),
                filtro.getCarcass(),
                filtro.getMaterial());
    }

    public Page<Product> buscarCategoriaInk(Pageable pageable, Filtro filtro){
        return productRepository.filterInk(pageable,
                filtro.getPriceMin(),
                filtro.getPriceMax(),
                filtro.getColor(),
                filtro.getDensity());
    }

    public Page<Product> buscarCategoriaAutomation(Pageable pageable, Filtro filtro){
        return productRepository.filterAutomation(pageable,
                filtro.getPriceMin(),
                filtro.getPriceMax(),
                filtro.getVoltage(),
                filtro.getRfi(),
                filtro.getTemperature());
    }

    public Page<Product> buscarCategoriaSecurity(Pageable pageable, Filtro filtro){
        return productRepository.filterSecurity(pageable,
                filtro.getPriceMin(),
                filtro.getPriceMax(),
                filtro.getFrequencyMax(),
                filtro.getFrequencyMin(),
                filtro.getVoltage());
    }

    public Page<Product> buscarCategoriaBuilding(Pageable pageable, Filtro filtro){
        return productRepository.filterBuilding(pageable,
                filtro.getPriceMin(),
                filtro.getPriceMax(),
                filtro.getPlug(),
                filtro.getBattery(),
                filtro.getCasing());
    }

    //

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
