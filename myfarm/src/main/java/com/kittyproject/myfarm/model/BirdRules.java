/**
 * 
 */
package com.kittyproject.myfarm.model;

import org.springframework.context.annotation.Configuration;

/**
 * @author Kthangav
 *
 */
@Configuration
public class BirdRules {

	private String type;
	private String mate;
	private boolean canLayEggs;
	private long eggLayTime;
	private long eggHatchingTime;
	private int perDayEggLayLimit;
	private double minWeightForLayEgg;
	private double minWeightForSale;
	private double maxWeightForSale;
	private long[] sleepTime;
	private long trainingTime;
	private String[] actions;
	private long timeToMate;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isCanLayEggs() {
		return canLayEggs;
	}

	public void setCanLayEggs(boolean canLayEggs) {
		this.canLayEggs = canLayEggs;
	}

	public long getEggLayTime() {
		return eggLayTime;
	}

	public void setEggLayTime(long eggLayTime) {
		this.eggLayTime = eggLayTime;
	}

	public long getEggHatchingTime() {
		return eggHatchingTime;
	}

	public void setEggHatchingTime(long eggHatchingTime) {
		this.eggHatchingTime = eggHatchingTime;
	}

	public int getPerDayEggLayLimit() {
		return perDayEggLayLimit;
	}

	public void setPerDayEggLayLimit(int perDayEggLayLimit) {
		this.perDayEggLayLimit = perDayEggLayLimit;
	}


	public String getMate() {
		return mate;
	}

	public void setMate(String mate) {
		this.mate = mate;
	}

	public long getTrainingTime() {
		return trainingTime;
	}

	public void setTrainingTime(long trainingTime) {
		this.trainingTime = trainingTime;
	}

	public double getMinWeightForLayEgg() {
		return minWeightForLayEgg;
	}

	public void setMinWeightForLayEgg(double minWeightForLayEgg) {
		this.minWeightForLayEgg = minWeightForLayEgg;
	}

	public double getMinWeightForSale() {
		return minWeightForSale;
	}

	public void setMinWeightForSale(double minWeightForSale) {
		this.minWeightForSale = minWeightForSale;
	}

	public double getMaxWeightForSale() {
		return maxWeightForSale;
	}

	public void setMaxWeightForSale(double maxWeightForSale) {
		this.maxWeightForSale = maxWeightForSale;
	}

	public String[] getActions() {
		return actions;
	}

	public void setActions(String[] actions) {
		this.actions = actions;
	}

	public long[] getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(long[] sleepTime) {
		this.sleepTime = sleepTime;
	}

	public long getTimeToMate() {
		return timeToMate;
	}

	public void setTimeToMate(long timeToMate) {
		this.timeToMate = timeToMate;
	}

	

}
