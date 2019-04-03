/**
 * 
 */
package com.kittyproject.myfarm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.kittyproject.myfarm.core.ActivateBird;
import com.kittyproject.myfarm.core.BirdRandomRuleGenerator;
import com.kittyproject.myfarm.model.Bird;
import com.kittyproject.myfarm.model.EggContainer;
import com.kittyproject.myfarm.model.Food;
import com.kittyproject.myfarm.model.Water;
import com.kittyproject.myfarm.utils.Commons;
import com.kittyproject.myfarm.vo.Birds;

/**
 * @author kthangav
 *
 */
@Component
public class FarmService {

	List<Bird> birds;
	List<Food> foods;
	Water water;
	EggContainer eggs;

	public FarmService() {
		birds = new ArrayList<>();
		foods = new ArrayList<>();
		eggs = new EggContainer();
		water = new Water();
		Map<String, List<Integer>> eggContainer = new HashMap<>();
		eggs.setEggs(eggContainer);
	}

	public Bird addBirdIntoFarm(Bird bird) {
		Bird initiateBird = new Bird();
		initiateBird.setType(bird.getType());
		initiateBird.setName(getNewBirdName(bird.getType()));
		initiateBird.setWeight(bird.getWeight());
		initiateBird.setFoodConsumed(bird.getFoodConsumed());
		BirdRandomRuleGenerator.applyRandomRuleForBird(initiateBird);
		birds.add(initiateBird);
		ActivateBird activateBird = new ActivateBird(initiateBird, birds, foods, water, eggs);
		activateBird.start();
		try {
			activateBird.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return initiateBird;
	}

	public Food loadFood(Food food) {
		Food newFood = new Food();
		newFood.setAvailableQty(food.getAvailableQty());
		newFood.setFoodType(food.getFoodType());
		foods.add(newFood);
		return newFood;
	}

	public Water fillWaterTank(Water tank) {
		water.setAvailalbeQty(tank.getAvailalbeQty());
		return water;
	}

	public List<Bird> retrieveAllBirds() {
		return birds;
	}

	public List<Birds> ListBirdsTodashboard() {
		List<Birds> birdsViewList = new ArrayList<>();
		List<Bird> birdTypes = birds.stream().filter(Commons.distinctByKey(bird -> bird.getType()))
				.collect(Collectors.toList());
		for (Bird bird : birdTypes) {
			Birds birdsView = new Birds();
			birdsView.setType(bird.getType());
			birdsView.setTotal(countBirdsOnType(bird.getType()));
			birdsView.setEggsAvailable(countBirdsEgg(bird));
			birdsViewList.add(birdsView);
		}
		return birdsViewList;
	}

	public long countBirdsOnType(String type) {
		return birds.stream().filter(bird -> type.equalsIgnoreCase(bird.getType())).count();
	}

	public long countBirdsEgg(Bird bird) {
		long totalegg = 0;
		for (Entry<String, List<Integer>> entry : eggs.getEggs().entrySet()) {
			if (entry.getKey().equalsIgnoreCase(bird.getType())) {
				totalegg = entry.getValue().stream().filter(total -> total > entry.getValue().size())
						.mapToLong(total -> total).sum();
				break;
			}
		}
		return totalegg;
	}

	private String getNewBirdName(String birdType) {
		return birdType + countBirdsOnType(birdType);
	}

	public List<Food> getFoodLists() {
		return foods;
	}

	public Water getWaterAvailable() {
		return water;
	}

}
