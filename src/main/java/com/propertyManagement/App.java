package com.propertyManagement;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.propertyManagement_configuration.Hibernatecfg;
import com.property_entity.Customer;
import com.property_entity.Dealer;
import com.property_entity.Property;

public class App {

	public static void main(String[] args) {

		boolean isContinue = true;
		Scanner sc = new Scanner(System.in);
		while (isContinue) {
			System.out.println("press 1 for add Dealer details..");
			System.out.println("press 2 for add Property details..");
			System.out.println("press 3 for add Customer details..");
			System.out.println("press 4 for update Dealer details..");
			System.out.println("press 5 for update Property details..");
			System.out.println("press 6 to sell property..");
			System.out.println("press 7 for delete Dealer details..");
			System.out.println("press 8 for delete Property details..");
			System.out.println("press 9 to exit..");
			int input = sc.nextInt();
			if (input == 1) {
				System.out.println("Enter dealer name..");
				String name = sc.next();
				System.out.println("Enter dealer phone no.");
				String phoneNo = sc.next();
				System.out.println("Enter dealer govt Id Type.");
				String govtIdType = sc.next();
				System.out.println("Enter dealer govt Id N.");
				String govtIdNumber = sc.next();
				Dealer dealer = new Dealer(name, govtIdType, govtIdNumber, phoneNo);
				saveDealer(dealer);
				System.out.println("Dealer data added successfully...");
			} else if (input == 2) {

				System.out.println("Enter property state...");
				String state = sc.next();
				System.out.println("Enter property city..");
				String city = sc.next();
				System.out.println("Enter property total Area...");
				String totalArea = sc.next();
				System.out.println("Enter the property dealer Id..");
				Long dealerId = sc.nextLong();
				System.out.println("Enter property per sqft price..");
				double perSqftPrice = sc.nextDouble();
				Dealer dealer = dealerDataById(dealerId);
				if (dealer != null) {
					Property property = new Property(dealerId, state, city, perSqftPrice, input,dealer, null);
					saveProperty(property);
					System.out.println("Property data added successfully..");
				} else {
					System.out.println("Dealer not existedwith provided id.");
				}
			
			}
				else if(input==3) {
					System.out.println("Enter customer name..");
					String name=sc.next();
					System.out.println("Enter customer govt Id Type..");
					String govtIdType=sc.next();
					System.out.println("Enter customer govt Id No..");
					String govtIdNo=sc.next();
					System.out.println("Enter customer buy Area..");
					double buyArea=sc.nextDouble();
					System.out.println("Enter property price");
					Double price=sc.nextDouble();
					System.out.println("Enter the customer property id");
					Long propertyId=sc.nextLong();
					Property property=propertyDataById(propertyId, buyArea);
					if(property != null) {
						
						Customer customer=new Customer(name, govtIdType, govtIdNo, buyArea, buyArea, property);
						saveCustomer(customer);
						System.out.println("Customer data added successfully..");
						
					}
					else {
						System.out.println("Property not existed with customer id");
					}
					
				}
				
				else if (input == 4) {
				System.out.println("update dealer phone No..");
				String phoneNo = sc.next();
				System.out.println("dealer deails update successfully..");
			 
			} 
				
				else if (input == 5) {
				System.out.println("update property total Area..");
				String totaArea = sc.next();
				System.out.println("update property per sqft price..");
				String perSqftPrice = sc.next();
				System.out.println("update property dealer Id ..");
				String dealerId = sc.next();
				System.out.println("property update successfully..");
			} else if (input == 6) {
				System.out.println("total property selling total Area ");
				String totalArea = sc.next();
				System.out.println("saved property selling details..");
			} else if (input == 8) {
				System.out.println("property total Area delete");
				String totalArea = sc.next();
				System.out.println("delete successfully..");
			} else {
				isContinue = false;
			}

		}
		System.out.println("Thanks you and visit again...");
	}

	private static Property propertyDataById(Long propertyId, double buyArea) {
		// TODO Auto-generated method stub
		Session session=Hibernatecfg.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		Property property=(Property) session.get(Property.class, propertyId);
		if(property!=null) {
		 if(property.getTotal_area()>=buyArea) {
				property.setTotal_area(property.getTotal_area()-buyArea);
				session.update(property);
			}
			else {
				System.out.println("not enough sqft available current:"+property.getTotal_area());
			}
		if(property.getTotal_area()>=buyArea) {
			System.out.println("property available..");
			session.update(property);
		}
		else {
			System.out.println("not enough sqft available current...");
			
		}
		}
		else
			{
				System.out.println("property not found");
			}
		
		tx.commit();
		session.close();
		return property;
	}

	public static void saveDealer(Dealer dealer) {
		
		Session session = Hibernatecfg.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(dealer);
		tx.commit();
		session.close();
		System.out.println("Dealer details added");

	}

	public static Dealer dealerDataById(Long dealerId) {
		Session session = Hibernatecfg.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Dealer dealer = (Dealer) session.get(Dealer.class, dealerId);
		tx.commit();
		session.close();
		return dealer;
	}

	public static void saveProperty(Property property) {
		
		Session session = Hibernatecfg.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(property);
		tx.commit();
		session.close();
		System.out.println("property details added");

	}

	public static void saveCustomer(Customer customer) {
		Session session = Hibernatecfg.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit();
		session.close();
		System.out.println("customer details added");

}
	

}
//}correct the code in hibernate

//        import java.util.Scanner;
//        import org.hibernate.Session;
//        import org.hibernate.Transaction;
//
//import com.propertyManagement_configuration.Hibernatecfg;
//import com.property_entity.Dealer;
//import com.property_entity.Property;
//
//        public class App {
//
//            public static void main(String[] args) {
//                boolean isContinue = true;
//                Scanner sc = new Scanner(System.in);
//
//                while (isContinue) {
//                    System.out.println("press 1 for add Dealer details..");
//                    System.out.println("press 2 for add Property details..");
//                    System.out.println("press 4 for update Dealer details..");
//                    System.out.println("press 5 for update Property details..");
//                    System.out.println("press 6 to sell property..");
//                    System.out.println("press 7 for delete Dealer details..");
//                    System.out.println("press 8 for delete Property details..");
//                    System.out.println("press 9 to exit..");
//
//                    int input = sc.nextInt();
//                    sc.nextLine(); 
//
//                    switch (input) {
//                        case 1:
//                            System.out.println("Enter dealer name:");
//                            String name = sc.nextLine();
//                            System.out.println("Enter dealer phone no:");
//                            String phoneNo = sc.nextLine();
//                            System.out.println("Enter dealer govt Id Type:");
//                            String govtIdType = sc.nextLine();
//                            System.out.println("Enter dealer govt Id Number:");
//                            String govtIdNumber = sc.nextLine();
//
//                            Dealer dealer = new Dealer(name, govtIdType, govtIdNumber, phoneNo);
//                            saveDealer(dealer);
//                            System.out.println("Dealer data added successfully...");
//                            break;
//
//                        case 2:
//                            System.out.println("Enter property state:");
//                            String state = sc.nextLine();
//                            System.out.println("Enter property city:");
//                            String city = sc.nextLine();
//                            System.out.println("Enter property total Area:");
//                            String totalArea = sc.nextLine();
//                            System.out.println("Enter the property dealer Id:");
//                            String dealerId = sc.nextLine();
//                            System.out.println("Enter property per sqft price:");
//                            String perSqftPrice = sc.nextLine();
//
//                 
//                            System.out.println("Property data added successfully..");
//                            break;
//


//                        case 4:
//                            System.out.println("Enter updated dealer phone No:");
//                            String updatedPhoneNo = sc.nextLine();
//                            
//                            System.out.println("Dealer details updated successfully..");
//                            break;
//
//                        case 5:
//                            System.out.println("Update property total Area:");
//                            String updatedTotalArea = sc.nextLine();
//                            System.out.println("Update property per sqft price:");
//                            String updatedPrice = sc.nextLine();
//                            System.out.println("Update property dealer Id:");
//                            String updatedDealerId = sc.nextLine();
//                            
//                            System.out.println("Property updated successfully..");
//                            break;
//
//                        case 6:
//                            System.out.println("Enter total property selling Area:");
//                            String sellArea = sc.nextLine();
//                            
//                            System.out.println("Saved property selling details..");
//                            break;
//
//                        case 7:
//                            System.out.println("Enter Dealer ID to delete:");
//                            String deleteDealerId = sc.nextLine();
//                            
//                            System.out.println("Dealer deleted successfully.");
//                            break;
//
//                        case 8:
//                            System.out.println("Enter property total Area to delete:");
//                            String deleteArea = sc.nextLine();
//                            
//                            System.out.println("Deleted successfully..");
//                            break;
//
//                        case 9:
//                            isContinue = false;
//                            break;
//
//                        default:
//                            System.out.println("Invalid input. Please try again.");
//                    }
//                }
//
//                sc.close();
//                System.out.println("Thank you and visit again...");
//            }
//
//            public static void saveDealer(Dealer dealer) {
//                Session session = Hibernatecfg.getSessionFactory().openSession();
//                Transaction tx = session.beginTransaction();
//                session.save(dealer);
//                tx.commit();
//                session.close();
//                System.out.println("Dealer details saved in the database.");
//            }
//            public static void saveProperty(Property dealer) {
//                Session session = Hibernatecfg.getSessionFactory().openSession();
//                Transaction tx = session.beginTransaction();
//                session.save(dealer);
//                tx.commit();
//                session.close();
//                System.out.println("Dealer details saved in the database.");
//            }
//        }
