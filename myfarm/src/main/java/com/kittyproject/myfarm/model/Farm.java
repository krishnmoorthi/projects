/**
 * 
 */
package com.kittyproject.myfarm.model;

import java.util.List;

import org.springframework.context.annotation.Configuration;

/**
 * The Class Farm.
 *
 * @author kthangav
 */
@Configuration
public class Farm {

	private List<Bird> birds;
	private List<BirdRules> birdsRules;
	private EggContainer eggContainer;

	public Farm() {
	}

	public EggContainer getEggContainer() {
		return eggContainer;
	}

	public void setEggContainer(EggContainer eggContainer) {
		this.eggContainer = eggContainer;
	}

	public List<Bird> getBirds() {
		return birds;
	}

	public void setBirds(List<Bird> birds) {
		this.birds = birds;
	}

	public List<BirdRules> getBirdsRules() {
		return birdsRules;
	}

	public void setBirdsRules(List<BirdRules> birdRules) {
		this.birdsRules = birdRules;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Farm [birds=" + birds + ", birdsRules=" + birdsRules + ", eggContainer=" + eggContainer + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birds == null) ? 0 : birds.hashCode());
		result = prime * result + ((birdsRules == null) ? 0 : birdsRules.hashCode());
		result = prime * result + ((eggContainer == null) ? 0 : eggContainer.hashCode());
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
		if (!(obj instanceof Farm)) {
			return false;
		}
		Farm other = (Farm) obj;
		if (birds == null) {
			if (other.birds != null) {
				return false;
			}
		} else if (!birds.equals(other.birds)) {
			return false;
		}
		if (birdsRules == null) {
			if (other.birdsRules != null) {
				return false;
			}
		} else if (!birdsRules.equals(other.birdsRules)) {
			return false;
		}
		if (eggContainer == null) {
			if (other.eggContainer != null) {
				return false;
			}
		} else if (!eggContainer.equals(other.eggContainer)) {
			return false;
		}
		return true;
	}

}
