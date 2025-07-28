package com.property_entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
	@Column(name = "Total area")
	private String total_area;
	@Column(name = "Dealer_id")
	private String dealer_id;
	@Column(name = "Per_Sqft_price")
	private double per_sqft_price;

	@ManyToOne
	@JoinColumn(name = "dealer_id")
	private Dealer dealer;

	@OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
	private List<Customer> customer;

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getState() {
		return state;
	}

	public final void setState(String state) {
		this.state = state;
	}

	public final String getCity() {
		return city;
	}

	public final void setCity(String city) {
		this.city = city;
	}

	public final String getTotal_area() {
		return total_area;
	}

	public final void setTotal_area(String total_area) {
		this.total_area = total_area;
	}

	public final String getDealer_id() {
		return dealer_id;
	}

	public final void setDealer_id(String dealer_id) {
		this.dealer_id = dealer_id;
	}

	public final double getPer_sqft_price() {
		return per_sqft_price;
	}

	public final void setPer_sqft_price(double per_sqft_price) {
		this.per_sqft_price = per_sqft_price;
	}

	public final Dealer getDealer() {
		return dealer;
	}

	public final void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public final List<Customer> getCustomer() {
		return customer;
	}

	public final void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public Property(Long id, String state, String city, String total_area, String dealer_id, double per_sqft_price,
			Dealer dealer, Customer cusomer) {
		super();
		this.id = id;
		this.state = state;
		this.city = city;
		this.total_area = total_area;
		this.dealer_id = dealer_id;
		this.per_sqft_price = per_sqft_price;
		this.dealer = dealer;
		this.customer = customer;
	}

	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", state=" + state + ", city=" + city + ", total_area=" + total_area
				+ ", dealer_id=" + dealer_id + ", per_sqft_price=" + per_sqft_price + ", dealer=" + dealer
				+ ", customer=" + customer + "]";
	}

}
