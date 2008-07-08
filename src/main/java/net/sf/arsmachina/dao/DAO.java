// Copyright 2007-2008 Thiago H. de Paula Figueiredo
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

/**
 * Interface that defines a read-write, generic and generified Data Access Object (DAO) for a given
 * entity class. It extends {@link ReadableDAO} and {@link WriteableDAO}.
 * 
 * @author Thiago H. de Paula Figueiredo (ThiagoHP)
 * @param <T> the entity class related to this DAO.
 * @param <K> the type of the field that represents the entity class' primary key.
 */
public interface DAO<T, K extends Serializable> extends ReadableDAO<T, K>,
		WriteableDAO<T, K> {

}
