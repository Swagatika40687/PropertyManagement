package com.property_entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "Govt_id_type")
	private String govt_id_type;
	@Column(name = "Govt_id_no")
	private String govt_id_no;
	@Column(name = "Buy_area")
	private String buy_area;
	@Column(name = "price")
	private double price;

	@ManyToOne
	@JoinColumn(name = "property_id")
	private Property property;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGovt_id_type() {
		return govt_id_type;
	}

	public void setGovt_id_type(String govt_id_type) {
		this.govt_id_type = govt_id_type;
	}

	public String getGovt_id_no() {
		return govt_id_no;
	}

	public void setGovt_id_no(String govt_id_no) {
		this.govt_id_no = govt_id_no;
	}

	public String getBuy_area() {
		return buy_area;
	}

	public void setBuy_area(String buy_area) {
		this.buy_area = buy_area;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
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

	public Customer(String name, String govt_id_type, String govt_id_no, String buy_area, double price,
			Property property) {
		super();
		this.name = name;
		this.govt_id_type = govt_id_type;
		this.govt_id_no = govt_id_no;
		this.buy_area = buy_area;
		this.price = price;
		this.property = property;
	}

}
