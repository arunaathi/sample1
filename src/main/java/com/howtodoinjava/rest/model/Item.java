package com.howtodoinjava.rest.model;

public class Item {
	 String itemname;
	 String imagename;
	 
	 public Item(String itemname,String imagename,double itmprice){
		 this.itemname=itemname;
		 this.imagename=imagename;
		 this.itmprice=itmprice;
	 }
	 public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public double getItmprice() {
		return itmprice;
	}
	public void setItmprice(double itmprice) {
		this.itmprice = itmprice;
	}
	double itmprice;
}
