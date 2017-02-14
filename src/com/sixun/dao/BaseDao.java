package com.sixun.dao;

import java.util.List;

/**
 * @author tk
 *crud²Ù×÷¸ú½Ó¿Ú
 */
public interface BaseDao<T> {
	
	public boolean add(T t);
	public boolean update(T t);
	public boolean delete(int id);
	
	public List<T> getAll();
	public T getById(int id);
	public List<T> getByName(String name);
}
