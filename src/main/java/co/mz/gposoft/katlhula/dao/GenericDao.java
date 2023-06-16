package co.mz.gposoft.katlhula.dao;

import java.util.Collection;
import java.util.Collections;

public interface GenericDao<T> {

    public T save(T t);

    public T findById(long id);

    public T update(T t);

    public T delete(T t);

    public Collection<T> findAll();


}
