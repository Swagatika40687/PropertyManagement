package com.property_entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="Govt_id_type")
	private String govt_id_type;
	@Column(name="Govt_id_no")
	private String govt_id_no;
	@Column(name="Buy_area")
	private String buy_area;
	@Column(name="price")
	private double price;
	
	@ManyToOne
	@JoinColumn(name="property_id")
	private Property property;

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getGovt_id_type() {
		return govt_id_type;
	}

	public final void setGovt_id_type(String govt_id_type) {
		this.govt_id_type = govt_id_type;
	}

	public final String getGovt_id_no() {
		return govt_id_no;
	}

	public final void setGovt_id_no(String govt_id_no) {
		this.govt_id_no = govt_id_no;
	}

	public final String getBuy_area() {
		return buy_area;
	}

	public final void setBuy_area(String buy_area) {
		this.buy_area = buy_area;
	}

	public final double getPrice() {
		return price;
	}

	public final void setPrice(double price) {
		this.price = price;
	}

	public final Property getProperty() {
		return property;
	}

	public final void setProperty(Property property) {
		this.property = property;
	}

	public Customer(Long id, String name, String govt_id_type, String govt_id_no, String buy_area, double price,
			Property property) {
		super();
		this.id = id;
		this.name = name;
		this.govt_id_type = govt_id_type;
		this.govt_id_no = govt_id_no;
		this.buy_area = buy_area;
		this.price = price;
		this.property = property;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", govt_id_type=" + govt_id_type + ", govt_id_no=" + govt_id_no
				+ ", buy_area=" + buy_area + ", price=" + price + ", property=" + property + "]";
	}
	

	
	

}
