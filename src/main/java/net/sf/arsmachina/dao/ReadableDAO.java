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

package net.sf.arsmachina.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Interface that defines a read-only, generic and generified Data Access Object (DAO) for a given
 * entity class.
 * 
 * @author Thiago H. de Paula Figueiredo (ThiagoHP)
 * @param <T> the entity class related to this DAO.
 * @param <K> the type of the field that represents the entity class' primary key.
 */

public interface ReadableDAO<T, K extends Serializable> {

	/**
	 * Returns the total number of objects of this class.
	 * @return an <code>int</code>.
	 */
	int countAll();
	
	/**
	 * Returns the object with a given primary key value.
	 * 
	 * @param id a <code>K</code>.
	 * @return a <code>T</code>.
	 */
	T findById(K id);

	/**
	 * Returns the objects with some given primary key values.
	 * 
	 * @param ids a <code>K</code> array.
	 * @return a {@link List} of <code>T</code>.
	 */
	List<T> findByIds(K... ids);

	/**
	 * Returns the all instances of the related entity class.
	 * 
	 * @return a {@link List} of <code>T</code>.
	 */
	List<T> findAll();

	/**
	 * Refreshes an object, overwriting its fields with values coming from the object store.
	 * 
	 * @param object a <code>T</code>
	 */
	void refresh(T object);

	/**
	 * Returns the all instances of the related entity class, but in a paginated fashion.
	 * 
	 * @param firstResult an <code>int</code> with the index of the first object to be returned.
	 * The first object has index 0.
	 * @param maxResults an <code>int</code> with the maximum number of objects to be returned.
	 * @param sortingConstraints an {@link SortCriterion} array used to define how the returned
	 * list will be sorted.
	 * @return a {@link List} of <code>T</code>.
	 */
	List<T> findAll(int firstResult, int maxResults, SortCriterion... sortingConstraints);

	/**
	 * Returns the default {@link SortCriterion}s to be used to sort the objects lists returned by
	 * methods like {@link #findAll()} and {@link #findAll(int, int, SortCriterion...)} when no
	 * sort constraints are given.
	 * 
	 * @return a {@link SortCriterion} array. It cannot be <code>null</code>.
	 */
	SortCriterion[] getDefaultSortCriteria();

}
