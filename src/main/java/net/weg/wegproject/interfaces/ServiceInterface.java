package net.weg.wegproject.interfaces;

import java.util.List;

public interface ServiceInterface<T>{

    public T create(T obj);
    public List<T> findAll();
    public T findOne(Long id);
    public T update(T obj);
    public T delete(Long id);
}
