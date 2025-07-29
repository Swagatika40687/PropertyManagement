package com.property_entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "property")
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "State")
	private String state;
	@Column(name = "City")
	private String city;
	@Column(name = "total_area")
	private String total_area;
	@Column(name = "Per_Sqft_price")
	private double per_sqft_price;

	@ManyToOne
	@JoinColumn(name = "dealer_id")
	private Dealer dealer;

	@OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
	private List<Customer> customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTotal_area() {
		return total_area;
	}

	public void setTotal_area(String total_area) {
		this.total_area = total_area;
	}

	public double getPer_sqft_price() {
		return per_sqft_price;
	}

	public void setPer_sqft_price(double per_sqft_price) {
		this.per_sqft_price = per_sqft_price;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public Property(Long id, String state, String city, String total_area, double per_sqft_price, Dealer dealer,
			Customer cusomer) {
		super();
		this.id = id;
		this.state = state;
		this.city = city;
		this.total_area = total_area;
		this.per_sqft_price = per_sqft_price;
		this.dealer = dealer;
		this.customer = customer;
	}

	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Property(String state, String city, String total_area, double per_sqft_price, Dealer dealer) {
		super();
		this.state = state;
		this.city = city;
		this.total_area = total_area;
		this.per_sqft_price = per_sqft_price;
		this.dealer = dealer;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", state=" + state + ", city=" + city + ", total_area=" + total_area
				+ ", per_sqft_price=" + per_sqft_price + ", dealer=" + dealer + ", customer=" + customer + "]";
	}

}
