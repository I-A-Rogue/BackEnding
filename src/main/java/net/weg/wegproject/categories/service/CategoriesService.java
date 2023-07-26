package net.weg.wegproject.categories.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.categories.model.entity.Categories;
import net.weg.wegproject.categories.repository.CategoriesRepository;
import net.weg.wegproject.interfeces.ServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CategoriesService implements ServiceInterface<Categories> {
    CategoriesRepository categoriesRepository;


    @Override
    public Categories create(Categories obj) {
        return categoriesRepository.save(obj);
    }

    @Override
    public List<Categories> findAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public Categories findOne(Long id) {
        try {
            return categoriesRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Categoria não encontrada");
        }
    }

    @Override
    public Categories update(Categories obj) {
        return categoriesRepository.save(obj);
    }

    @Override
    public Categories delete(Long id) {
        Categories categories = this.findOne(id);
        categoriesRepository.delete(categories);
        return categories;
    }
}
