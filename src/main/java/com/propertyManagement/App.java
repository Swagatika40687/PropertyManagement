package com.propertyManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.propertyManagement_configuration.Hibernatecfg;
import com.property_entity.Customer;
import com.property_entity.Dealer;
import com.property_entity.Property;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
//        Customer customer=new Customer();
//        customer.setId(null);
//        customer.setName("Sushree");
//        customer.setGovt_id_no("09096743456");
//        customer.setGovt_id_type("Adhar");
//        customer.setBuy_area("1500 sqft");
//        customer.setPrice(7800000.00);
//        
//        Property property=new Property();
//        property.setId(null);
//        property.setState("Odisha");
//        property.setCity("Bhubaneswar");
//        property.setPer_sqft_price(5000);
//        property.setDealer_id("Er45");
//        property.setTotal_area("4000 sqft");
//        property.setCustomer(customer);
//        
//        Property property1=new Property();
//        property1.setId(null);
//        property1.setState("Odisha");
//        property1.setCity("Cuttack");
//        property1.setPer_sqft_price(6800);
//        property1.setDealer_id("Df34");
//        property1.setTotal_area("8000 sqft");
//        
//        Property property2=new Property();
//        property2.setId(null);
//        property2.setState("Odisha");
//        property2.setCity("Bhubaneswar");
//        property2.setPer_sqft_price(8000);
//        property2.setDealer_id("Rt67");
//        property2.setTotal_area("6000Sqft");
//        property.setCustomer(customer);
//        
//        
//        Dealer dealer=new Dealer();
//        dealer.setId(null);
//        dealer.setName("Rakesh");
//        dealer.setGovt_id_no("DSAE456");
//        dealer.setGovt_id_type("PAN");
//        dealer.setProperty(property,property2);
//        
//        Dealer dealer1=new Dealer();
//        dealer1.setId(null);
//        dealer1.setName(null);
//        dealer.setGovt_id_no(null);
//        dealer.setGovt_id_type(null);
//        dealer.setProperty(property,property1);
//      
//        List<Dealer>dealers = new ArrayList<>();
//        saveDealer(dealer);
//        saveDealer(dealer1);
        
      boolean isContinue=true;
      Scanner sc=new Scanner(System.in);
      while(isContinue) {
    	  System.out.println("press 1 for add Dealer details..");
    	  System.out.println("press 2 for add Property details..");
    	  System.out.println("press 4 for update Dealer details..");
    	  System.out.println("press 5 for update Property details..");
    	  System.out.println("press 6 to sell property..");
    	  System.out.println("press 7 for delete Dealer details..");
    	  System.out.println("press 8 for delete Property details..");
    	  System.out.println("press 9 to exit..");
    	  int input=sc.nextInt();
    	  if(input==1) {
    		  System.out.println("Enter dealer name..");
    		  String name=sc.next();
    		  System.out.println("Enter dealer phone no.");
    		  String phoneNo=sc.next();
    		  System.out.println("Enter dealer govt Id Type.");
    		  String govtIdType=sc.next();
    		  System.out.println("Enter dealer govt Id N.");
    		  String govtIdNumber=sc.next();
    		  Dealer dealer=new Dealer(name, govtIdType, govtIdNumber, phoneNo);
    		  saveDealer(dealer);
    		  System.out.println("Dealer data added successfully...");
    	  }
    	  else {
    		  isContinue=false;
    	  }
    	 
      }
      System.out.println("Thanks you and visit again...");
    }

      public static void saveDealer(Dealer dealer) {
		// TODO Auto-generated method stub
    	  Session session=Hibernatecfg.getSessionFactory().openSession();
    	  Transaction tx=session.beginTransaction();
    	  session.save(dealer);
    	  tx.commit();
    	  session.close();
    	  System.out.println("property details added");
    	  
		
	}
}
