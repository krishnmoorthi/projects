/**
 * 
 */
package com.kittyproject.myfarm.model;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Configuration;

/**
 * The Class EggContainer.
 *
 * @author kthangav
 */
@Configuration
public class EggContainer {
	
	public EggContainer() {}

	/** The eggs. */
	Map<String,List<Integer>> eggs;

	/**
	 * Gets the eggs.
	 *
	 * @return the eggs
	 */
	public Map<String, List<Integer>> getEggs() {
		return eggs;
	}

	/**
	 * Sets the eggs.
	 *
	 * @param eggs the eggs
	 */
	public void setEggs(Map<String, List<Integer>> eggs) {
		this.eggs = eggs;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EggContainer [eggs=" + eggs + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eggs == null) ? 0 : eggs.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		if (!(obj instanceof EggContainer)) {
			return false;
		}
		EggContainer other = (EggContainer) obj;
		if (eggs == null) {
			if (other.eggs != null) {
				return false;
			}
		} else if (!eggs.equals(other.eggs)) {
			return false;
		}
		return true;
	}
}
