package com.howtodoinjava.rest.model;

import java.util.ArrayList;
import java.util.List;

public class Details {
	/*
	 * Person p1; public Person getP1() { return p1; } public void setP1(Person p1)
	 * { this.p1 = p1; } List<Iteminfo> it1; public List<Iteminfo> getIt1() { return
	 * it1; } public void setIt1(List<Iteminfo> it1) { this.it1 = it1; }
	 */
	Person person;
	
	ArrayList<ProdGroup> prodgrp;
	
	ArrayList<Product> prod;
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public ArrayList<ProdGroup> getProdgrp() {
		return prodgrp;
	}

	public void setProdgrp(ArrayList<ProdGroup> prodgrp) {
		this.prodgrp = prodgrp;
	}

	public ArrayList<Product> getProd() {
		return prod;
	}

	public void setProd(ArrayList<Product> prod) {
		this.prod = prod;
	}
	
}
