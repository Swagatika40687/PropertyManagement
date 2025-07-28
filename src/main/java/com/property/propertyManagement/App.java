package com.property.propertyManagement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.property.cfg.PropertyConfiguration;
import com.property.entity.Dealer;
import com.property.entity.Property;



public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Property property=new Property();
        property.setId(null);
        property.setPropertyName("left 3550sqft");
        property.setAddress("Cuttack");
        property.setCity("Cuttack");
        property.setState("Odisha");
        property.setPrice(800000.00);
        property.setOwnerDetails("Rakesh,ADERG123,7890677890");
        
        Property property1=new Property();
        property1.setId(null);
        property1.setPropertyName("Right 4536sqft");
        property1.setAddress("Nakhara");
        property1.setCity("Bhubaneswar");
        property1.setState("Odisha");
        property1.setPrice(600000.00);
        property1.setOwnerDetails("Susant,ADth00,789578968");
        
        Property property2=new Property();
        property2.setId(null);
        property2.setPropertyName("Left 4500sqft");
        property2.setAddress("patia");
        property2.setCity("Bhubaneswat");
        property2.setState("Odisha");
        property2.setPrice(500000.00);
        property2.setOwnerDetails("Akash,ASDF3456,467757788");
        
        Dealer dealer=new Dealer();
        dealer.setId(null);
        dealer.setName("Vikash");
        dealer.setGovtId("BH09");
        dealer.setContactNumber("9876556789");
        dealer.setAdharNumber("DG345672Gjt67");
        dealer.setProperty(property1,property2);
          
        Dealer dealer1=new Dealer();
        dealer1.setId(null);
        dealer1.setName("Avinash");
        dealer1.setGovtId("BH08");
        dealer1.setContactNumber("9876556780");
        dealer1.setAdharNumber("DG345672Gjt78");
        dealer1.setProperty(property,property2);
        List<Dealer> dealers= new ArrayList<>();
        saveDealer(dealer);
        saveDealer(dealer1);
 
        
    }

	public static void saveDealer(Dealer dealer) {

			Session session =PropertyConfiguration.getSessionFactory().openSession();
			Transaction trn = session.beginTransaction();
	        session.save(dealer);
			trn.commit();
			session.close();
			System.out.println("Employee data saved.");
		}
}
