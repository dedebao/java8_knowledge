/**
 * 
 */
package com.simple.example.InnerClass;

import java.util.ArrayList;
import java.util.List;

/** 
 * @ClassName: Invoice 
 * @Description: 静态嵌套类
 * 当内部类的实例不需要知道它属于外部类的哪个实例时,使用静态嵌套类
 * @author: pengyu
 * @date: 2018年7月30日 下午12:35:15  
 */

public class Invoice {
	
	//私有的静态嵌套类，只有Invoice方法能访问
	private static class Item1{
		String description;
		int quantity;
		double unitPrice;
		double price() {
			return quantity * unitPrice;
		}
	}
	
	private ArrayList<Item1> items1=new ArrayList<>();
		
	public void addItem1(String description,int quantity,double unitPrice) {
		Item1 newItem=new Item1();
		newItem.description=description;
		newItem.quantity=quantity;
		newItem.unitPrice=unitPrice;
		items1.add(newItem);
	}
	
	//一个工有的嵌套类，需要使用通常的封装机制
	public static class Item2{
		String description;
		int quantity;
		double unitPrice;
		/**
		 * @param description
		 * @param quantity
		 * @param unitPrice
		 */
		public Item2(String description, int quantity, double unitPrice) {
			super();
			this.description = description;
			this.quantity = quantity;
			this.unitPrice = unitPrice;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getUnitPrice() {
			return unitPrice;
		}
		public void setUnitPrice(double unitPrice) {
			this.unitPrice = unitPrice;
		}
		
		
	}
	
	private List<Item2> items2=new ArrayList<>(); 
	
	public void addItem2(Item2 item2) {
		items2.add(item2);
	}
		
	public static void main(String[] args) {
		Invoice invoice=new Invoice();
		Invoice.Item2 itemobj=new Invoice.Item2("football player2", 20, 19.95);
		invoice.addItem2(itemobj);
		invoice.addItem1("football player1", 20, 19.95);
	}

}
