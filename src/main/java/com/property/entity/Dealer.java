package com.property.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dealer")
public class Dealer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="name")
	private String name;
	@Column (name="contactnumber")
	private String ContactNumber;
	@Column(name="govtid")
	private String GovtId;
	@Column(name="adharno")
	private String AdharNumber;
	@OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL)
    private List<Property> property ;
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
	public String getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}
	public String getGovtId() {
		return GovtId;
	}
	public void setGovtId(String govtId) {
		GovtId = govtId;
	}
	public String getAdharNumber() {
		return AdharNumber;
	}
	public void setAdharNumber(String adharNumber) {
		AdharNumber = adharNumber;
	}
	public List<Property> getProperty() {
		return property;
	}
	public void setProperty(List<Property> property) {
		this.property = property;
	}
	public Dealer(Long id, String name, String contactNumber, String govtId, String adharNumber,
			List<Property> property) {
		super();
		this.id = id;
		this.name = name;
		ContactNumber = contactNumber;
		GovtId = govtId;
		AdharNumber = adharNumber;
		this.property = property;
	}
	public Dealer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Dealer [id=" + id + ", name=" + name + ", ContactNumber=" + ContactNumber + ", GovtId=" + GovtId
				+ ", AdharNumber=" + AdharNumber + ", property=" + property + "]";
	}
	public void setProperty(Property property1, Property property2) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
