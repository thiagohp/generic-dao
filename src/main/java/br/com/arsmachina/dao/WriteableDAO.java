// Copyright 2008 Thiago H. de Paula Figueiredo
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package br.com.arsmachina.dao;

import java.io.Serializable;

/**
 * Interface that defines a read-write, generic and generified Data Access Object (DAO) for a given
 * entity class.
 * 
 * @author Thiago H. de Paula Figueiredo (ThiagoHP)
 * @param <T> the entity class related to this DAO.
 * @param <K> the type of the field that represents the entity class' primary key.
 */
public interface WriteableDAO<T, K extends Serializable> {

	/**
	 * Removes an object.
	 * 
	 * @param object a <code>T</code>.
	 */
	void delete(T object);

	/**
	 * Removes an object given its primary key.
	 * 
	 * @param id a <code>K</code>.
	 */
	void delete(K id);

	/**
	 * Saves (inserts) an object.
	 * 
	 * @param object a <code>T</code>.
	 */
	void save(T object);

	/**
	 * Updates an object.
	 * 
	 * @param object a <code>T</code>.
	 */
	void update(T object);

	/**
	 * Merges an object with the current persistence context. This method only has meaningful
	 * implementations when used with ORM frameworks that have a merge concept (Hibernate, JPA,
	 * etc).
	 * 
	 * @param object a <code>T</code>.
	 * @return a <code>T</code>.
	 */
	T merge(T object);

	/**
	 * Removes an object from the current persistence context. This method only has meaningful
	 * implementations when used with ORM frameworks that have an evict concept (Hibernate, JPA,
	 * etc).
	 * 
	 * @param object a <code>T</code>.
	 * @return a <code>T</code>.
	 */
	void evict(T object);

	/**
	 * Tells whether a given object is already persistent or not.
	 * 
	 * @return a <code>boolean</code>.
	 */
	boolean isPersistent(T object);

}
