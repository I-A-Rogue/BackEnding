package net.weg.wegproject.ConcreteClasses.saves.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.saves.model.entity.Saves;
import net.weg.wegproject.ConcreteClasses.saves.repository.SavesRepository;
import net.weg.wegproject.interfaces.ServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SavesService implements ServiceInterface<Saves> {
    SavesRepository savesRepository;

    @Override
    public Saves create(Saves obj) {
        try {
            return savesRepository.save(obj);
        } catch (Exception e) {
            throw new RuntimeException("Save already exists");
        }
    }

    @Override
    public List<Saves> findAll() {
        try {
            return savesRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Save not found");
        }
    }

    @Override
    public Saves findOne(Long id) {
        try {
            return savesRepository.findById(id).orElseThrow();
        } catch (Exception e) {
            throw new RuntimeException("Save not found");
        }
    }

    @Override
    public Saves update(Saves obj) {
        try {
            return savesRepository.save(obj);
        } catch (Exception e) {
            throw new RuntimeException("Save not found");
        }
    }

    @Override
    public Saves delete(Long id) {
        try {
            Saves save = findOne(id);
            savesRepository.delete(save);
            return save;
        }catch (Exception e) {
            throw new RuntimeException("Save not found");
        }
    }
}
