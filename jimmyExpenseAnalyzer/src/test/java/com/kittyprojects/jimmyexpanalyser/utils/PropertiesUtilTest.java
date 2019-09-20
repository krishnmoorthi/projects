/**
 * 
 */
package com.kittyprojects.jimmyexpanalyser.utils;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.kittyprojects.jimmyexpanalyser.constants.PropertyConstants;

/**
 * @author krishnamoorthi
 *
 */
public class PropertiesUtilTest {

	/**
	 * Test method for
	 * {@link com.kittyprojects.jimmyexpanalyser.utils.PropertiesUtil#loadproperties(java.lang.String)}.
	 */
	@Test
	public void testLoadproperties() {
		Assert.assertNotNull(PropertiesUtil.loadproperties("app.properties"));
		Map<String, String> mapOfOpertion = PropertiesUtil.loadproperties("app.properties");
		Assert.assertEquals(mapOfOpertion.get(PropertyConstants.APP_ROOTLOCATION), ".");
	}

}
