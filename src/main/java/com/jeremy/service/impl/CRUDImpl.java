package com.jeremy.service.impl;

import com.jeremy.repository.IBaseRepository;
import com.jeremy.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID>  {
	
	protected abstract IBaseRepository<T, ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public List<T> readAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().deleteById(id);
    }

}
