// Copyright 2008-2009 Thiago H. de Paula Figueiredo
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
 * @author Thiago H. de Paula Figueiredo
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
	 * Updates an object. If it is not persistent, an {@link IllegalArgumentException} is 
	 * thrown. The return value must be the object that is attached to the persistence
	 * context of the underlying implementation, if it exists.  Otherwise, this method
	 * simply returns the object passed as a parameter. This return value was added
	 * to deal ORM frameworks like JPA, that do not attach the updated object
	 * to the persistence context. See <code>EntityManager.merge()</code>. 
	 * 
	 * @param object a <code>T</code>.
	 * @return a <code>T</code>.
	 * @throws IllegalArgumentException if <code>object</code> is null or not persistent.
	 */
	T update(T object);

	/**
	 * Removes an object from the current persistence context. This method only has meaningful
	 * implementations when used with ORM frameworks that have an evict concept (Hibernate, etc).
	 * Otherwise, implementations this method will do nothing.
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
