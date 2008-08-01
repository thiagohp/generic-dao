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

/**
 * Used to represent a sorting criterion (constraint) to be applied to a method that returns objects.
 * 
 * @author Thiago H. de Paula Figueiredo (ThiagoHP)
 */
public class SortCriterion {

	private String property;

	private boolean ascending;

	/**
	 * Single constructor of this class.
	 * 
	 * @param property a {@link String} containing the property to be used to sort the returned
	 * objects. It can be a property path. It cannot be null.
	 * @param ascending a <code>boolean</code> telling if the sorting will be ascending or
	 * descending.
	 */
	public SortCriterion(String property, boolean ascending) {

		if (property == null) {
			throw new IllegalArgumentException("Parameter property cannot be null");
		}

		this.property = property;
		this.ascending = ascending;

	}

	/**
	 * @return a {@link String}.
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * @return a {@link boolean}.
	 */
	public boolean isAscending() {
		return ascending;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return property + (ascending ? " asc" : " desc");
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ascending ? 1231 : 1237);
		result = prime * result + ((property == null) ? 0 : property.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final SortCriterion other = (SortCriterion) obj;
		if (ascending != other.ascending) {
			return false;
		}
		if (property == null) {
			if (other.property != null) {
				return false;
			}
		}
		else if (!property.equals(other.property)) {
			return false;
		}

		return true;

	}

}
