/**
 * 
 */
package com.kittyprojects.jimmyexpanalyser.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.kittyprojects.jimmyexpanalyser.constants.CommonConstants;

/**
 * @author kthangav
 *
 */
public class DateUtil {

	public static String dateToMMMYYYY(String dateStr) {
		DateTimeFormatter inputformat = DateTimeFormatter.ofPattern(CommonConstants.LEDGER_DATE_FIELD_FORMAT);
		DateTimeFormatter monthformat = DateTimeFormatter.ofPattern(CommonConstants.LEDGER_MONTH_FORMAT);
		LocalDateTime datetime = LocalDateTime.parse(dateStr, inputformat);
		return datetime.format(monthformat);
	}

}
