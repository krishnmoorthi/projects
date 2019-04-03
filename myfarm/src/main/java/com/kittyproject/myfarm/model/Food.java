/**
 * 
 */
package com.kittyproject.myfarm.model;

/**
 * @author Kthangav
 *
 */
public class Food {

	private String foodType;
	private double availableQty;

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(double availableQty) {
		this.availableQty = availableQty;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Food [foodType=" + foodType + ", availableQty=" + availableQty + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(availableQty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((foodType == null) ? 0 : foodType.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		if (!(obj instanceof Food)) {
			return false;
		}
		Food other = (Food) obj;
		if (Double.doubleToLongBits(availableQty) != Double.doubleToLongBits(other.availableQty)) {
			return false;
		}
		if (foodType == null) {
			if (other.foodType != null) {
				return false;
			}
		} else if (!foodType.equals(other.foodType)) {
			return false;
		}
		return true;
	}

}
