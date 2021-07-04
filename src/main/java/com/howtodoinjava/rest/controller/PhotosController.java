package com.howtodoinjava.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.rest.model.Details;
import com.howtodoinjava.rest.model.Item;
import com.howtodoinjava.rest.model.Person;
import com.howtodoinjava.rest.model.Photo;
import com.howtodoinjava.rest.model.Post;

@RestController
@RequestMapping(path = "/Photos")
public class PhotosController 
{
    
    @GetMapping(path="/", produces = "application/json")
    public Map fetchinfo()
    {
    	Map<String,Object> m=new HashMap<String,Object>();
    	Details d1=new Details();
    	Person p1=new Person();
    	p1.setName("Arun");
    	p1.setEmail("Arun@yahoo.co.in");
    	
      ArrayList<Item> i1=new ArrayList<>();
      i1.add(new Item("Apple","images/apple.jpg",10.00));
      i1.add(new Item("Tomato","images/tomato.jpg",15.00));
      i1.add(new Item("Lemon","images/lemons.jpg",25.00));
      i1.add(new Item("Kiwi Fruit","images/kiwi.jpg",10.00));
      i1.add(new Item("Guava","images/guava.jpg",5.00));
      i1.add(new Item("Grapes","images/grapes.jpg",1.00));
      
      ArrayList<Item> i2=new ArrayList<>();
      i2.add(new Item("Pineapple","images/pineapple.jpg",1.00));
      i2.add(new Item("Apple","images/apple.jpg",10.00));
      i2.add(new Item("Apple","images/apple.jpg",10.00));
      i2.add(new Item("Apple","images/apple.jpg",10.00));
      i2.add(new Item("Apple","images/apple.jpg",10.00));
      i2.add(new Item("Apple","images/apple.jpg",10.00));
      
    	System.out.println("Enter...inside....");
       List<Photo> al=new ArrayList<>();
       al.add(new Photo("images/veg.jpg","Avilable1",i1));
       al.add(new Photo("images/frozen.jpg","Avilable2",i2));
       al.add(new Photo("images/bev.jpg","Avilable3",i1));
       al.add(new Photo("images/brand_f.jpg","Avilable4",i2));
       al.add(new Photo("images/be.jpg","Available5",i1));
       al.add(new Photo("images/home.jpg","Avilable6",i2));
       al.add(new Photo("images/nonveg.jpg","Available7",i1));
       al.add(new Photo("images/eggs.jpg","Avilable8",i2));
       al.add(new Photo("images/nonveg.jpg","Available9",i1));
       al.add(new Photo("images/eggs.jpg","Avilable10",i2));
      // d1.setP1(p1);
      // d1.setPh1(al);
       m.put("RESULT","SUCCESS");
       m.put("DISP_DATA",d1);
       return m;
    }
    @GetMapping(path="/post", produces = "application/json")
    public List<Post> getPost() 
    {
    	System.out.println("Enter...inside....Post");
       ArrayList<Post> al=new ArrayList<>();
       al.add(new Post(1111,1,"Arun1","dfsdfsd1"));
       al.add(new Post(2222,2,"Arun2","dfsdfsd2"));
       al.add(new Post(3333,3,"Arun3","dfsdfsd3"));
       return al;
    }
}
