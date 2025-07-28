package com.property_entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "dealer")
public class Dealer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "Govt_id_type")
	private String govt_id_type;
	@Column(name = "Govt_id_no")
	private String govt_id_no;
	@Column(name = "phoneNo")
	private String phoneNo;

	@OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL)
	private List<Property> property;

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

	public final List<Property> getProperty() {
		return property;
	}

	public final void setProperty(List<Property> property) {
		this.property = property;
	}

	public Dealer(Long id, String name, String govt_id_type, String govt_id_no, List<Property> property) {
		super();
		this.id = id;
		this.name = name;
		this.govt_id_type = govt_id_type;
		this.govt_id_no = govt_id_no;
		this.property = property;
	}

	public Dealer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setProperty(Property property2, Property property22) {
		// TODO Auto-generated method stub

	}

	public final String getPhoneNo() {
		return phoneNo;
	}

	public final void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Dealer(String name, String govt_id_type, String govt_id_no, String phoneNo) {
		super();
		this.name = name;
		this.govt_id_type = govt_id_type;
		this.govt_id_no = govt_id_no;
		this.phoneNo = phoneNo;
	}

}
