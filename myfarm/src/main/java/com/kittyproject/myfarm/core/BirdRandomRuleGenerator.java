/**
 * 
 */
package com.kittyproject.myfarm.core;

import java.util.Random;

import com.kittyproject.myfarm.common.ChickenConstant;
import com.kittyproject.myfarm.common.CountryChickenConstant;
import com.kittyproject.myfarm.common.CountryRoosterConstant;
import com.kittyproject.myfarm.common.EggConstants;
import com.kittyproject.myfarm.common.RoosterConstants;
import com.kittyproject.myfarm.model.Bird;
import com.kittyproject.myfarm.model.BirdRules;

/**
 * @author kthangav
 *
 */
public class BirdRandomRuleGenerator {

	public static void applyRandomRuleForBird(Bird bird) {
		String type = bird.getType();
		BirdRules rule = new BirdRules();
		rule.setCanLayEggs(getCanLayEggs(type));
		rule.setEggHatchingTime(getEggHatchingTime(type));
		rule.setEggLayTime(getEggLayTime(type));
		rule.setMate(getMatchMate(type));
		rule.setMaxWeightForSale(getMaxWeight(type));
		rule.setMinWeightForLayEgg(getMinWeight(type));
		rule.setPerDayEggLayLimit(getPerDayEggLimit(type));
		rule.setSleepTime(getSleepTime(type));
		rule.setTrainingTime(getChicksTrainingTime(type));
		rule.setActions(getBirdAction(type));
		bird.setBirdRule(rule);
	}

	public static String[] getTraineeBirdAction() {
		return new String[] { "feedfood", "sleep", "feedwater" };
	}

	private static String[] getBirdAction(String type) {
		if ("Chicken".equalsIgnoreCase(type) || "CountryChicken".equalsIgnoreCase(type)) {
			return new String[] { "feedfood", "sleep", "feedwater", "mate", "egghatching", "layegg" };
		} else {
			return new String[] { "feedfood", "sleep", "feedwater", "mate" };
		}
	}

	private static long getChicksTrainingTime(String type) {
		if ("Chicken".equalsIgnoreCase(type)) {
			return ChickenConstant.TRAINING_TIME;
		} else if ("CountryChicken".equalsIgnoreCase(type)) {
			return CountryChickenConstant.TRAINING_TIME;
		} else if ("Rooster".equalsIgnoreCase(type)) {
			return RoosterConstants.TRAINING_TIME;
		} else {
			return CountryRoosterConstant.TRAINING_TIME;
		}
	}

	private static double getMaxWeight(String type) {
		if ("Chicken".equalsIgnoreCase(type)) {
			return ChickenConstant.MAX_WEIGHT_TO_SELL;
		} else if ("CountryChicken".equalsIgnoreCase(type)) {
			return CountryChickenConstant.MAX_WEIGHT_TO_SELL;
		} else if ("Rooster".equalsIgnoreCase(type)) {
			return RoosterConstants.MAX_WEIGHT_TO_SELL;
		} else {
			return CountryRoosterConstant.MAX_WEIGHT_TO_SELL;
		}
	}

	private static double getMinWeight(String type) {
		if ("Chicken".equalsIgnoreCase(type)) {
			return ChickenConstant.MIN_WEIGHT_TO_SELL;
		} else if ("CountryChicken".equalsIgnoreCase(type)) {
			return CountryChickenConstant.MIN_WEIGHT_TO_SELL;
		} else if ("Rooster".equalsIgnoreCase(type)) {
			return RoosterConstants.MIN_WEIGHT_TO_SELL;
		} else {
			return CountryRoosterConstant.MIN_WEIGHT_TO_SELL;
		}
	}

	private static long[] getSleepTime(String type) {
		if ("Chicken".equalsIgnoreCase(type)) {
			return ChickenConstant.SLEEP_TIME;
		} else if ("CountryChicken".equalsIgnoreCase(type)) {
			return CountryChickenConstant.SLEEP_TIME;
		} else if ("Rooster".equalsIgnoreCase(type)) {
			return RoosterConstants.SLEEP_TIME;
		} else {
			return CountryRoosterConstant.SLEEP_TIME;
		}
	}

	private static boolean getCanLayEggs(String type) {
		if ("Chicken".equalsIgnoreCase(type) || "CountryChicken".equalsIgnoreCase(type)) {
			return ChickenConstant.LAY_EGGS;
		} else {
			return false;
		}
	}

	private static long getEggLayTime(String type) {
		if ("Chicken".equalsIgnoreCase(type)) {
			return ChickenConstant.EGG_LAY_TIME;
		} else if ("CountryChicken".equalsIgnoreCase(type)) {
			return CountryChickenConstant.EGG_LAY_TIME;
		} else {
			return 0;
		}
	}

	private static int getPerDayEggLimit(String type) {
		if ("Chicken".equalsIgnoreCase(type)) {
			return randomEggLimitChooser(EggConstants.CHICKEN_PER_DAY_EGG_LIMIT);
		} else if ("CountryChicken".equalsIgnoreCase(type)) {
			return randomEggLimitChooser(EggConstants.COUNTRY_CHICKEN_PER_DAY_EGG_LIMIT);
		} else {
			return 0;
		}
	}

	private static long getEggHatchingTime(String type) {
		if ("Chicken".equalsIgnoreCase(type)) {
			return randomTimeChooser(EggConstants.CHICKEN_EGG_HATCH_TIME);
		} else if ("CountryChicken".equalsIgnoreCase(type)) {
			return randomTimeChooser(EggConstants.COUNTRY_CHICKEN_EGG_HATCH_TIME);
		} else if ("Rooster".equalsIgnoreCase(type)) {
			return randomTimeChooser(EggConstants.ROOSTER_EGG_HATCH_TIME);
		} else {
			return randomTimeChooser(EggConstants.COUNTRY_ROOSTER_EGG_HATCH_TIME);
		}
	}

	private static String getMatchMate(String type) {
		if ("Chicken".equalsIgnoreCase(type)) {
			return ChickenConstant.MATE_TYPE;
		} else if ("CountryChicken".equalsIgnoreCase(type)) {
			return CountryChickenConstant.MATE_TYPE;
		} else if ("RoosterChicken".equalsIgnoreCase(type)) {
			return RoosterConstants.MATE_TYPE;
		} else {
			return CountryRoosterConstant.MATE_TYPE;
		}
	}

	public static long randomTimeChooser(long[] times) {
		Random random = new Random();
		int time = random.nextInt(times.length) + 1;
		return times[time - 1];
	}

	private static int randomEggLimitChooser(int[] egglimit) {
		Random random = new Random();
		int eggs = random.nextInt(egglimit.length) + 1;
		return egglimit[eggs - 1];
	}

}
