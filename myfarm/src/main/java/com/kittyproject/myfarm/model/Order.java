/**
 * 
 */
package com.kittyproject.myfarm.model;

import org.springframework.context.annotation.Configuration;

/**
 * @author kthangav
 *
 */
@Configuration
public class Order {
	
	private String name;
	private String eggtype;
	private Integer quantity;
	private Integer consumed;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEggtype() {
		return eggtype;
	}
	public void setEggtype(String eggtype) {
		this.eggtype = eggtype;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getConsumed() {
		return consumed;
	}
	public void setConsumed(Integer consumed) {
		this.consumed = consumed;
	} 

}
