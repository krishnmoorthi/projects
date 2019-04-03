/**
 * 
 */
package com.kittyproject.myfarm.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kittyproject.myfarm.service.FarmService;

/**
 * @author kthangav
 *
 */
@Controller
public class FarmUIController {

	@Autowired
	FarmService farmservice;

	@GetMapping("/farm")
	public String farm(Locale locale, Model model) {
		model.addAttribute("birdsList", farmservice.ListBirdsTodashboard());
		model.addAttribute("foodList", farmservice.getFoodLists());
		model.addAttribute("water", farmservice.getWaterAvailable());
		return "farm";
	}
}
