/**
 * 
 */
package com.kittyproject.myfarm.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.kittyproject.myfarm.common.FoodConstants;
import com.kittyproject.myfarm.model.Bird;
import com.kittyproject.myfarm.model.EggContainer;
import com.kittyproject.myfarm.model.Food;
import com.kittyproject.myfarm.model.Water;
import com.kittyproject.myfarm.utils.UnitCalculations;

/**
 * @author kthangav
 *
 */
public class BirdActions {

	private List<Bird> birds;
	private List<Food> foods;
	private Water water;
	private EggContainer eggs;

	public void perform(Bird bird, String action) {
		if ("feedfood".equalsIgnoreCase(action)) {
			feedFood(bird);
		} else if ("feedwater".equalsIgnoreCase(action)) {
			feedWater(bird);
		} else if ("sleep".equalsIgnoreCase(action)) {
			sleep(bird);
		} else if ("mate".equalsIgnoreCase(action)) {
			mate(bird);
		} else if ("egghatching".equalsIgnoreCase(action)) {
			eggHatching(bird);
		} else {
			if ((bird.getBirdRule().getMinWeightForLayEgg() <= bird.getWeight())) {
				if (bird.isMated()) {
					layEggs(bird);
					bird.setMated(false);
				} else {

				}
			} else {
				System.out.println("Bird under weight for laying eggs");
			}
		}
	}

	private void layEggs(Bird bird) {
		Random random = new Random();
		int egg = random.nextInt(bird.getBirdRule().getPerDayEggLayLimit()) + 1;
		bird.setEggsLaid(bird.getEggsLaid() + egg);
		eggContainersStatus(bird, egg);
		System.out.println(bird.getName() + " laid [" + egg + "] eggs");
	}

	private void eggContainersStatus(Bird bird, int egg) {
		if (null != eggs.getEggs().get(bird.getType())) {
			eggs.getEggs().get(bird.getType()).add(egg);
		} else {
			List<Integer> eggcounter = new ArrayList<>();
			eggcounter.add(egg);
			eggs.getEggs().put(bird.getType(), eggcounter);
		}
	}

	private void mate(Bird bird) {
		if (bird.getWeight() > 300) {
			for (Bird matebird : birds) {
				if (bird.getBirdRule().getMate().equalsIgnoreCase(matebird.getType())) {
					if (matebird.isMated() == false && bird.isMated() == false) {
						matebird.setMated(true);
						bird.setMated(true);
						System.out.println(bird.getName() + " mated with " + matebird.getName());
						break;
					}
				}
			}
		} else {
			System.out.println("Bird [" + bird.getName() + "] is not reached expected weight for mating !");
		}
	}

	private void feedFood(Bird bird) {
		if (foods.size() > 0) {
			Food food = foods.get(ThreadLocalRandom.current().nextInt(foods.size()));
			double consumed = ThreadLocalRandom.current().nextDouble();
			bird.setFoodConsumed(bird.getFoodConsumed() + consumed);
			gainBirdWeight(bird, food.getFoodType());
			consumed = food.getAvailableQty() - (consumed / 1000);
			food.setAvailableQty(consumed);
			System.out.println("Food [" + food.getFoodType() + "] consumed by [" + bird.getName() + "]");
		} else {
			System.out.println("No foods available for feeding !,  please load it !");
		}
	}

	private void gainBirdWeight(Bird bird, String foodType) {
		if (FoodConstants.FOODS_CAN_EAT[0].equalsIgnoreCase(foodType)) {
			bird.setWeight(bird.getWeight() + UnitCalculations.kiloGramToGram(FoodConstants.GRAINS_WEIGHT_GAIN));
		} else if (FoodConstants.FOODS_CAN_EAT[1].equalsIgnoreCase(foodType)) {
			bird.setWeight(bird.getWeight() + UnitCalculations.kiloGramToGram(FoodConstants.EARTH_WARM_WEIGHT_GAIN));
		} else {
			bird.setWeight(bird.getWeight() + UnitCalculations.kiloGramToGram(FoodConstants.INSECTS_WEIGHT_GAIN));
		}
		System.out.println("Weight gained [" + bird.getWeight() + "]");
	}

	private void feedWater(Bird bird) {
		if (water.getAvailalbeQty() > 0) {
			double consumed = ThreadLocalRandom.current().nextDouble();
			consumed = bird.getWaterConsumed() + consumed;
			bird.setWaterConsumed(consumed);
			System.out.println("Water [" + consumed + "] consumed by [" + bird.getName() + "]");
			consumed = water.getAvailalbeQty() - (consumed / 1000);
			water.setAvailalbeQty(consumed);
		} else {
			System.out.println("Water not available, Please fill the tank !");
		}

	}

	private void sleep(Bird bird) {
		System.out.println(bird.getName() + " is Sleeping");
	}

	private void eggHatching(Bird bird) {
		if (eggs.getEggs().isEmpty()) {
			System.out.println(
					"No Eggs present in container - can't allocate bird " + bird.getName() + " for egg hatching");
		} else {
			System.out.println(bird.getName() + " allocated for egg hatching");
		}
	}

	/**
	 * @return the birds
	 */
	public List<Bird> getBirds() {
		return birds;
	}

	/**
	 * @param birds
	 *            the birds to set
	 */
	public void setBirds(List<Bird> birds) {
		this.birds = birds;
	}

	/**
	 * @return the foods
	 */
	public List<Food> getFoods() {
		return foods;
	}

	/**
	 * @param foods
	 *            the foods to set
	 */
	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	/**
	 * @return the water
	 */
	public Water getWater() {
		return water;
	}

	/**
	 * @param water
	 *            the water to set
	 */
	public void setWater(Water water) {
		this.water = water;
	}

	public EggContainer getEggs() {
		return eggs;
	}

	public void setEggs(EggContainer eggs) {
		this.eggs = eggs;
	}

}
