package com.property.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="property")
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="propertyname")
	private String PropertyName;
	@Column(name="address")
	private String address;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String State;
	@Column(name="ownerDetails")
	private String OwnerDetails;
	@Column(name="price")
	private double price;
	@ManyToOne
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPropertyName() {
		return PropertyName;
	}
	public void setPropertyName(String propertyName) {
		PropertyName = propertyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getOwnerDetails() {
		return OwnerDetails;
	}
	public void setOwnerDetails(String ownerDetails) {
		OwnerDetails = ownerDetails;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Dealer getDealer() {
		return dealer;
	}
	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}
	public Property(Long id, String propertyName, String address, String city, String state, String ownerDetails,
			double price, Dealer dealer) {
		super();
		this.id = id;
		PropertyName = propertyName;
		this.address = address;
		this.city = city;
		State = state;
		OwnerDetails = ownerDetails;
		this.price = price;
		this.dealer = dealer;
	}
	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Property [id=" + id + ", PropertyName=" + PropertyName + ", address=" + address + ", city=" + city
				+ ", State=" + State + ", OwnerDetails=" + OwnerDetails + ", price=" + price + ", dealer=" + dealer
				+ "]";
	}
	
	
	}
	

	
	


