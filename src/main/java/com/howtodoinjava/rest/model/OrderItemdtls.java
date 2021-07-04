package com.howtodoinjava.rest.model;

import java.util.ArrayList;

import com.sun.tools.javac.jvm.Items;

public class OrderItemdtls {
String mobileNo;
String name;
String address;
String items;

public String getItems() {
	return items;
}
public void setItems(String items) {
	this.items = items;
}
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

}
