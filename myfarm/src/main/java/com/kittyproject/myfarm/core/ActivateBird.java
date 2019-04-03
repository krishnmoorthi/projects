/**
 * 
 */
package com.kittyproject.myfarm.core;

import java.util.List;
import java.util.Random;

import com.kittyproject.myfarm.common.FoodConstants;
import com.kittyproject.myfarm.model.Bird;
import com.kittyproject.myfarm.model.EggContainer;
import com.kittyproject.myfarm.model.Food;
import com.kittyproject.myfarm.model.Water;

/**
 * @author kthangav
 *
 */
public class ActivateBird extends Thread {

	/** The t. */
	Thread thread;

	private Bird bird;

	private BirdActions birdAction;

	public ActivateBird(Bird bird, List<Bird> birds, List<Food> foods, Water water,EggContainer eggs) {
		this.setBird(bird);
		birdAction = new BirdActions();
		birdAction.setBirds(birds);
		birdAction.setFoods(foods);
		birdAction.setWater(water);
		birdAction.setEggs(eggs);
	}

	@Override
	public void run() {
		try {
			while (bird.isActive()) {
				String action = "";
				if (bird.getWeight() < 300 && bird.getWeight() > 5) {
					System.out.println("Bird is in training !");
					action = getBirdAction(BirdRandomRuleGenerator.getTraineeBirdAction());
				} else {
					action = getBirdAction(bird.getBirdRule().getActions());
				}
				birdAction.perform(bird, action);
				Thread.sleep(birdActionTiming(action));
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + bird.getName() + " interrupted.");
		}

	}

	private String getBirdAction(String[] actions) {
		Random random = new Random();
		int action = random.nextInt(actions.length) + 1;
		return bird.getBirdRule().getActions()[action - 1];
	}

	private long birdActionTiming(String action) {
		if ("feedfood".equalsIgnoreCase(action)) {
			return BirdRandomRuleGenerator.randomTimeChooser(FoodConstants.FOOD_FEED_TIME);
		} else if ("feedwater".equalsIgnoreCase(action)) {
			return BirdRandomRuleGenerator.randomTimeChooser(FoodConstants.WATER_FEED_TIME);
		} else if ("sleep".equalsIgnoreCase(action)) {
			return BirdRandomRuleGenerator.randomTimeChooser(bird.getBirdRule().getSleepTime());
		} else if ("mate".equalsIgnoreCase(action)) {
			return 10000;
		} else if ("egghatching".equalsIgnoreCase(action)) {
			return bird.getBirdRule().getEggHatchingTime();
		} else {
			return bird.getBirdRule().getEggLayTime();
		}
	}

	/**
	 * Start.
	 */
	public void start() {
		System.out.println("Putting " + bird.getName() + " into the Farm !");
		bird.setActive(true);
		if (thread == null) {
			thread = new Thread(this, bird.getName());
			thread.start();
		}
	}

	public Bird getBird() {
		return bird;
	}

	public void setBird(Bird bird) {
		this.bird = bird;
	}

}
