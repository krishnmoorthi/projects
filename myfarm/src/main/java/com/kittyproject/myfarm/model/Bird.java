/**
 * 
 */
package com.kittyproject.myfarm.model;

import org.springframework.context.annotation.Configuration;

import com.kittyproject.myfarm.model.BirdRules;

/**
 * @author kthangav
 *
 */
@Configuration
public class Bird  {

	private String name;
	private String type;
	private boolean isActive;
	private boolean isMated;
	private double weight;
	private double foodConsumed;
	private double waterConsumed;
	private Integer eggsLaid;
	private boolean isReadyForShip;
	private BirdRules BirdRule;
	private String status;
		

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getEggsLaid() {
		return eggsLaid;
	}

	public void setEggsLaid(Integer eggsLaid) {
		this.eggsLaid = eggsLaid;
	}

	public boolean isMated() {
		return isMated;
	}

	public void setMated(boolean isMated) {
		this.isMated = isMated;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getFoodConsumed() {
		return foodConsumed;
	}

	public void setFoodConsumed(double foodConsumed) {
		this.foodConsumed = foodConsumed;
	}

	public boolean isReadyForShip() {
		return isReadyForShip;
	}

	public void setReadyForShip(boolean isReadyForShip) {
		this.isReadyForShip = isReadyForShip;
	}


	public BirdRules getBirdRule() {
		return BirdRule;
	}

	public void setBirdRule(BirdRules birdRule) {
		BirdRule = birdRule;
	}

	public double getWaterConsumed() {
		return waterConsumed;
	}

	public void setWaterConsumed(double waterConsumed) {
		this.waterConsumed = waterConsumed;
	}

	@Override
	public String toString() {
		return "Bird [name=" + name + ", type=" + type + ", isActive=" + isActive + ", isMated=" + isMated + ", weight="
				+ weight + ", foodConsumed=" + foodConsumed + ", waterConsumed=" + waterConsumed + ", eggsLaid="
				+ eggsLaid + ", isReadyForShip=" + isReadyForShip + ", BirdRule=" + BirdRule + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eggsLaid == null) ? 0 : eggsLaid.hashCode());
		long temp;
		temp = Double.doubleToLongBits(foodConsumed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + (isMated ? 1231 : 1237);
		result = prime * result + (isReadyForShip ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		temp = Double.doubleToLongBits(waterConsumed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bird other = (Bird) obj;
		if (eggsLaid == null) {
			if (other.eggsLaid != null)
				return false;
		} else if (!eggsLaid.equals(other.eggsLaid))
			return false;
		if (Double.doubleToLongBits(foodConsumed) != Double.doubleToLongBits(other.foodConsumed))
			return false;
		if (isActive != other.isActive)
			return false;
		if (isMated != other.isMated)
			return false;
		if (isReadyForShip != other.isReadyForShip)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (Double.doubleToLongBits(waterConsumed) != Double.doubleToLongBits(other.waterConsumed))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	




}
