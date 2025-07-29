package com.propertyManagement;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.propertyManagement_configuration.Hibernatecfg;
import com.property_entity.Customer;
import com.property_entity.Dealer;
import com.property_entity.Property;

public class App {
//
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
				String perSqftPrice = sc.next();
				Dealer dealer = dealerDataById(dealerId);
				if (dealer != null) {
					Property property = new Property(state, city, perSqftPrice, input, dealer);
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
					String buyArea=sc.next();
					System.out.println("Enter property price");
					Double price=sc.nextDouble();
					System.out.println("Enter the customer property id");
					Long propertyId=sc.nextLong();
					Property property=propertyDataById(propertyId);
					if(property != null) {
						
						Customer customer=new Customer(name,govtIdType,govtIdNo,buyArea,price,property);
						saveCustomer(customer);
						System.out.println("Customer data added successfully..");
						
					}
					else {
						System.out.println("Property not existed with customer id");
					}
				}
				
				else if (input == 4) {
					System.out.println("Enter dealer id to update:");
                    Long updateDealerId = sc.nextLong();
                    Dealer updateDealer = dealerDataById(updateDealerId);
                    if (updateDealer != null) {
                        System.out.println("Enter new phone number:");
                        String newPhone = sc.next();
                        updateDealer.setPhoneNo(newPhone);
                        System.out.println("Dealer updated.");
                    } else {
                        System.out.println("Dealer not found.");
                    }
				}
				else if (input == 5) {
					System.out.println("Enter property ID to update:");
                    Long updatePropertyId = sc.nextLong();
                    Property updateProperty = propertyDataById(updatePropertyId);
                    if (updateProperty != null) {
                        System.out.println("Enter new total area:");
                        String Area = sc.next();
                        System.out.println("Enter new price per sqft:");
                        double newPrice = sc.nextDouble();
                        updateProperty.setTotal_area(Area);
                        updateProperty.setPer_sqft_price(newPrice);
                      
                        System.out.println("Property updated.");
                    } else {
                        System.out.println("Property not found.");
                    }
			} else if (input == 6) {
				 System.out.println("Enter property ID to sell:");
                 Long sellPropertyId = sc.nextLong();
                 Property sellProperty = propertyDataById(sellPropertyId);
                 if (sellProperty != null) {
                     
                     System.out.println("Property marked as sold.");
                 } else {
                     System.out.println("Property not found.");
                 }
			}
				 else if(input==7){
					 System.out.println("Enter dealer ID to delete:");
	                    Long deleteDealerId = sc.nextLong();
	                    deleteDealerById(deleteDealerId); 
				 }
				 
			
			else if(input==8) {
				System.out.println("property total Area delete");
				Long deletePropId = sc.nextLong();
                deletePropertyById(deletePropId);
				
			} else {
				isContinue = false;
			}
	System.out.println("Thanks you and visit again...");
	}
	}
	
	 public static void saveDealer(Dealer dealer) {
	        Session session = Hibernatecfg.getSessionFactory().openSession();
	        Transaction tx = session.beginTransaction();
	        session.save(dealer);
	        tx.commit();
	        session.close();
	        System.out.println("Dealer saved successfully.");
	    }

	    public static Dealer dealerDataById(Long dealerId) {
	        Session session = Hibernatecfg.getSessionFactory().openSession();
	        Dealer dealer = session.get(Dealer.class, dealerId);
	        session.close();
	        return dealer;
	    }

	    public static void saveProperty(Property property) {
	        Session session = Hibernatecfg.getSessionFactory().openSession();
	        Transaction tx = session.beginTransaction();
	        session.save(property);
	        tx.commit();
	        session.close();
	        System.out.println("Property saved successfully.");
	    }

	    public static Property propertyDataById(Long propertyId) {
	        Session session = Hibernatecfg.getSessionFactory().openSession();
	        Property property = session.get(Property.class, propertyId);
	        session.close();
	        return property;
	    }

	    public static void saveCustomer(Customer customer) {
	        Session session = Hibernatecfg.getSessionFactory().openSession();
	        Transaction tx = session.beginTransaction();
	        session.save(customer);
	        tx.commit();
	        session.close();
	        System.out.println("Customer saved successfully.");
	    }

	    public static void updateEntity(Object entity) {
	        Session session = Hibernatecfg.getSessionFactory().openSession();
	        Transaction tx = session.beginTransaction();
	        session.update(entity);
	        tx.commit();
	        session.close();
	    }

	    public static void deleteDealerById(Long dealerId) {
	        Session session = Hibernatecfg.getSessionFactory().openSession();
	        Dealer dealer = session.get(Dealer.class, dealerId);
	        if (dealer != null) {
	            Transaction tx = session.beginTransaction();
	            session.delete(dealer);
	            tx.commit();
	            System.out.println("Dealer deleted successfully.");
	        } else {
	            System.out.println("Dealer not found.");
	        }
	        session.close();
	    }

	    public static void deletePropertyById(Long propertyId) {
	        Session session = Hibernatecfg.getSessionFactory().openSession();
	        Property property = session.get(Property.class, propertyId);
	        if (property != null) {
	            Transaction tx = session.beginTransaction();
	            session.delete(property);
	            tx.commit();
	            System.out.println("Property deleted successfully.");
	        } else {
	            System.out.println("Property not found.");
	        }
	        session.close();
	    }
	}

//	public static void saveDealer(Dealer dealer) {
//		// TODO Auto-generated method stubtt
//		Session session = Hibernatecfg.getSessionFactory().openSession();
//		Transaction tx = session.beginTransaction();
//		session.save(dealer);
//		tx.commit();
//		session.close();
//		System.out.println("Dealer details added");
//
//	}
//
//	public static Dealer dealerDataById(Long dealerId) {
//		Session session = Hibernatecfg.getSessionFactory().openSession();
//		Transaction tx = session.beginTransaction();
//		Dealer dealer = (Dealer) session.get(Dealer.class, dealerId);
//		tx.commit();
//		session.close();
//		return dealer;
//	}
//
//	public static void saveProperty(Property property) {
//		// TODO Auto-generated method stubtt
//		Session session = Hibernatecfg.getSessionFactory().openSession();
//		Transaction tx = session.beginTransaction();
//		session.save(property);
//		tx.commit();
//		session.close();
//		System.out.println("property details added");
//
//	}
//	public static Property propertyDataById(Long propertyId) {
//		Session session = Hibernatecfg.getSessionFactory().openSession();
//		Transaction tx = session.beginTransaction();
//	Property property= (Property) session.get(Property.class, propertyId);
//		tx.commit();
//		session.close();
//		return property;
//	}
//	public static void saveCustomer(Customer customer) {
//		Session session = Hibernatecfg.getSessionFactory().openSession();
//		Transaction tx = session.beginTransaction();
//		session.save(customer);
//		tx.commit();
//		session.close();
//		System.out.println("customer details added");
//
//			// TODO Auto-generated method stubtt
//
//}
//	
//}
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
