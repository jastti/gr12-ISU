package Tsystem;

import java.util.List;

/* This is an Interface for classes to use
 * based on there are some methods in common
 */
public interface ADO<T> {
	void add(T t);

	void delete(String ID);

	T find(String ID);

	List<T> findAll();
}
