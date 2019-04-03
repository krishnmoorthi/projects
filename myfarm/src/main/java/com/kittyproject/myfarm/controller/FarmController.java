/**
 * 
 */
package com.kittyproject.myfarm.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kittyproject.myfarm.model.Bird;
import com.kittyproject.myfarm.model.Food;
import com.kittyproject.myfarm.model.Water;
import com.kittyproject.myfarm.service.FarmService;

/**
 * @author kthangav
 *
 */
@RestController
public class FarmController {

	@Autowired
	FarmService farmservice;

	@GetMapping("/farm/birds")
	public List<Bird> retrieveAllBirds() {
		return farmservice.retrieveAllBirds();
	}

	@PostMapping("/farm/bird/add")
	public ResponseEntity<Void> addBirdInFarm(@RequestBody Bird bird) {
		Bird newBird = farmservice.addBirdIntoFarm(bird);
		if (newBird == null)
			return ResponseEntity.unprocessableEntity().eTag("Rule not present for Bird Type").build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}")
				.buildAndExpand(newBird.getName()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PostMapping("/farm/food")
	public ResponseEntity<Void> loadFood(@RequestBody Food food) {
		Food newfood = farmservice.loadFood(food);
		if (newfood == null)
			return ResponseEntity.unprocessableEntity().eTag("Rule not present for Bird Type").build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{foodType}")
				.buildAndExpand(newfood.getFoodType()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/farm/fill/water")
	public ResponseEntity<Void> FillWaterTank(@RequestBody Water freshWater) {
		Water water = farmservice.fillWaterTank(freshWater);
		if (water == null)
			return ResponseEntity.unprocessableEntity().eTag("Fill water tank").build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{availalbeQty}")
				.buildAndExpand(water.getAvailalbeQty()).toUri();

		return ResponseEntity.created(location).build();
	}

}
