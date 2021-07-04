package com.howtodoinjava.rest.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.howtodoinjava.rest.model.ConfigProp;
import com.howtodoinjava.rest.model.Details;
import com.howtodoinjava.rest.model.Iteminfo;
import com.howtodoinjava.rest.model.OrderItemdtls;
import com.howtodoinjava.rest.model.Post;
import com.howtodoinjava.rest.model.ProdGroup;
import com.howtodoinjava.rest.model.Product;
import com.howtodoinjava.rest.model.RegInfo;
import com.howtodoinjava.rest.model.Regverify;

@RestController
@RequestMapping(path = "/Items")
public class ItmsController 
{
	/*
	 * @Autowired ConfigProp confinfo;
	 */ 
	
	String folderPath="C:\\gro\\";
	static HashMap<String, String> valmob=new HashMap<>();
	
	
	
	private void sentMail(String toadd,String mobno) throws AddressException, MessagingException, IOException {
		Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
		   String fromid="arunaathi@gmail.com";
		   String pword="mugesh1980";
		   Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication(fromid, pword);
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress(fromid, false));

		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toadd));
		   msg.setSubject("OTP from Gro");
		   Random rand = new Random(); 
		   int rand_int1 = rand.nextInt(1000000);
		   String ranval=String.format("%6d",rand_int1);
		   valmob.put(mobno, ranval);
		   msg.setContent("OTP is "+ranval, "text/html");
		   msg.setSentDate(new Date());

			/*
			 * MimeBodyPart messageBodyPart = new MimeBodyPart();
			 * messageBodyPart.setContent("Tutorials point email", "text/html");
			 */
		   
			/*
			 * Multipart multipart = new MimeMultipart();
			 * multipart.addBodyPart(messageBodyPart); MimeBodyPart attachPart = new
			 * MimeBodyPart();
			 * 
			 * attachPart.attachFile("/var/tmp/image19.png");
			 * multipart.addBodyPart(attachPart); msg.setContent(multipart);
			 */		   
		   Transport.send(msg);
		   System.out.println("Sent Sucessfull...");
		}
	
	@PostMapping(path="/valDts", produces = "application/json")
    public String valinfo(@RequestBody String iinfo)
    {	
		System.out.println(iinfo);
		ObjectMapper mapper = new ObjectMapper();
		try {
			Regverify reginfo = mapper.readValue(iinfo, Regverify.class);
			System.out.println(reginfo.getMobno());
			System.out.println(reginfo.getMpin());
			System.out.println(reginfo.getOtp());
			String serverotp=valmob.get(reginfo.getMobno());
			if(serverotp!=null && serverotp.equals(reginfo.getOtp())) {
				System.out.println("otp validated..");
				
			}
			System.out.println(reginfo);
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Success";
    }
	
	@PostMapping(path="/regDtls", produces = "application/json")
    public String reginfo(@RequestBody String iinfo)
    {
    		 
    		System.out.println(iinfo);
    		ObjectMapper mapper = new ObjectMapper();
    		try {
				RegInfo reginfo = mapper.readValue(iinfo, RegInfo.class);
				System.out.println(reginfo.getMobno());
				System.out.println(reginfo.getMailid()); 
				System.out.println(reginfo);
					File f=new File("C:\\gro\\");
		    		if(!f.exists()) {
		    			f.mkdirs();
		    		}
		    		f=new File(folderPath+"reginfo.properties");
		    		FileWriter fw=new FileWriter(f,true);
		    		BufferedWriter bw=new BufferedWriter(fw);
		    		bw.write(reginfo.getMobno()+"="+reginfo.getMailid()+"|"+reginfo.getRefcode()+"\n");
		    		bw.close();
		    		fw.close();
		    		sentMail(reginfo.getMailid(),reginfo.getMobno());
		    		return "Success";
		   } catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	  return "Fail...";
    }

	
    @GetMapping(path="/", produces = "application/json")
    public Details fetchinfo()
    {
    	Map<String,Object> m=new HashMap<String,Object>();
    	Details d1=new Details();
    	ArrayList<ProdGroup> pgroup=new ArrayList<ProdGroup>();
    	System.out.println("Enter Info...");
        File f=new File("C:\\gro\\prodgrp.csv");
    	try {
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String currLine=br.readLine();
			while(currLine!=null) {
				String currDtl[]=currLine.split(",");
				ProdGroup curinfo=new ProdGroup();
				curinfo.setProdgroup_id(currDtl[0]);
				curinfo.setProdgroup_name(currDtl[1]);
				curinfo.setProdgroup_img(currDtl[2]);
				pgroup.add(curinfo);
				currLine=br.readLine();
			}
			br.close();
			fr.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	d1.setProdgrp(pgroup);
    	f=new File("C:\\gro\\prod.csv");
    	ArrayList<Product> prod =new ArrayList<Product>();
    	try {
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String currLine=br.readLine();
			while(currLine!=null) {
				String currDtl[]=currLine.split(",");
				Product curinfo=new Product();
				curinfo.setProdgroup_id(currDtl[0]);
				curinfo.setProduct_id(Integer.parseInt(currDtl[1]));
				curinfo.setProduct_thumb_img(currDtl[2]);
				curinfo.setSub_category_name(currDtl[3]);
				curinfo.setProduct_name(currDtl[4]);
				curinfo.setQuantity_units(currDtl[5]);
				curinfo.setMax_price(currDtl[6]);
				curinfo.setSale_price(currDtl[7]);
				curinfo.setOffer_quotes(currDtl[8]);
				curinfo.setProduct_decription(currDtl[9]);
				curinfo.setCart_qty(Integer.parseInt(currDtl[10]));
				curinfo.setIs_favourite(currDtl[11]);
				prod.add(curinfo);
				currLine=br.readLine();
			}
			br.close();
			fr.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	d1.setProd(prod);
    	System.out.println("Enter...inside....");
       m.put("RESULT","SUCCESS");
       m.put("DISP_DATA",d1);
       System.out.println(m.toString()); 
       //return m;
       return d1;
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
    
    @PostMapping(path="/addItemdtls", produces = "application/json")
    public String storeinfo(@RequestBody String iinfo)
    {
    		 
    		System.out.println(iinfo);
    		ObjectMapper mapper = new ObjectMapper();
    		try {
				OrderItemdtls orditem = mapper.readValue(iinfo, OrderItemdtls.class);
				System.out.println(orditem.getMobileNo());
				System.out.println(orditem.getName());
				System.out.println(orditem.getAddress());
				System.out.println(orditem.getItems()); 
				Iteminfo[] itemdtls=mapper.readValue(orditem.getItems(), Iteminfo[].class);
				System.out.println(itemdtls.length);
				System.out.println(orditem);
				StringBuffer orderitems=new StringBuffer();
				for(Iteminfo curinfo:itemdtls) {
					if(curinfo.getQty()!=null &&Integer.parseInt(curinfo.getQty())!=0) {
						if(orderitems.toString().equals("")) {
							orderitems.append(curinfo.getItemname()+","+curinfo.getItemprice()+","+curinfo.getQty());
						}else {
							orderitems.append("\n"+curinfo.getItemname()+","+curinfo.getItemprice()+","+curinfo.getQty());
						}
					}
				}
				if(!orderitems.toString().equals("")) {
					File f=new File("C:\\gro\\orderfolder\\");
		    		if(!f.exists()) {
		    			f.mkdirs();
		    		}
		    		f=new File("C:\\gro\\orderfolder\\"+orditem.getMobileNo()+".csv");
		    		FileWriter fw=new FileWriter(f);
		    		BufferedWriter bw=new BufferedWriter(fw);
		    		bw.write(orderitems.toString());
		    		bw.close();
		    		fw.close();
		    		return "Success";
		    	}else {
		    		return "Nothing Ordered..";
				}
			
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	  return "Fail...";
    }
}
