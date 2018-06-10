package com.webTrekk.customer;

import java.util.Date;

public class customerBasicDetailsDTO {

	
	int id;
	String dob;
	NameDTO name;
	int gender;
	Date lastContact;
	String customerLifetimeValue;
	Date birthday;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDob() {
		return dob;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getCustomerLifetimeValue() {
		return customerLifetimeValue;
	}
	public Date getLastContact() {
		return lastContact;
	}
	public void setLastContact(Date lastContact) {
		this.lastContact = lastContact;
	}
	public void setCustomerLifetimeValue(String customerLifetimeValue) {
		this.customerLifetimeValue = customerLifetimeValue;
	}
	public void setName(NameDTO name) {
		this.name = name;
	}
	public NameDTO getName() {
		return name;
	}
	public void setFirstName(String first) {
		this.name.setFirst(first);
	}
	public String getFirstName() {
		return name.getFirst();
	}
	public void setLastName(String last) {
		this.name.setLast(last);
	}
	public String getLasttName(String first) {
		return name.getLast();
	}
	
}
