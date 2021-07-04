package com.howtodoinjava.rest.model;

public class Product {
	  String prodgroup_id;
	  int product_id;
	  String product_thumb_img;
	  String sub_category_name;
	  String product_name;
	  String quantity_units;
	  String max_price;
	  String sale_price;
	  String offer_quotes;
	  String product_decription;
	  int cart_qty;
	  String is_favourite;
	public String getProdgroup_id() {
		return prodgroup_id;
	}
	public void setProdgroup_id(String prodgroup_id) {
		this.prodgroup_id = prodgroup_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_thumb_img() {
		return product_thumb_img;
	}
	public void setProduct_thumb_img(String product_thumb_img) {
		this.product_thumb_img = product_thumb_img;
	}
	public String getSub_category_name() {
		return sub_category_name;
	}
	public void setSub_category_name(String sub_category_name) {
		this.sub_category_name = sub_category_name;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getQuantity_units() {
		return quantity_units;
	}
	public void setQuantity_units(String quantity_units) {
		this.quantity_units = quantity_units;
	}
	public String getMax_price() {
		return max_price;
	}
	public void setMax_price(String max_price) {
		this.max_price = max_price;
	}
	public String getSale_price() {
		return sale_price;
	}
	public void setSale_price(String sale_price) {
		this.sale_price = sale_price;
	}
	public String getOffer_quotes() {
		return offer_quotes;
	}
	public void setOffer_quotes(String offer_quotes) {
		this.offer_quotes = offer_quotes;
	}
	public String getProduct_decription() {
		return product_decription;
	}
	public void setProduct_decription(String product_decription) {
		this.product_decription = product_decription;
	}
	public int getCart_qty() {
		return cart_qty;
	}
	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
	}
	public String getIs_favourite() {
		return is_favourite;
	}
	public void setIs_favourite(String is_favourite) {
		this.is_favourite = is_favourite;
	}
}
