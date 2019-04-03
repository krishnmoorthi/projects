/**
 * 
 */
package com.kittyproject.myfarm.utils;

/**
 * @author kthangav
 *
 */
public class UnitCalculations {
	
	
	public static double gramToKiloGram(double gram) {
		return Math.abs(gram / 1000);
	}
	
	public static double kiloGramToGram(double kilogram) {
		return Math.abs(kilogram * 1000);
	}
	
	public static double millilitreToLitre(double millilitre) {
		return Math.abs(millilitre * 1000);
	}

}
