package com.aadhar.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long aadharNumber;
	String name;
	char gender;
	long phoneNo;
	String city;
	public User(long aadharNumber, String name, char gender, long phoneNo, String city) {
		super();
		this.aadharNumber = aadharNumber;
		this.name = name;
		this.gender = gender;
		this.phoneNo = phoneNo;
		this.city = city;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public int hashCode() {
		return Objects.hash(aadharNumber, city, gender, name, phoneNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return aadharNumber == other.aadharNumber && Objects.equals(city, other.city) && gender == other.gender
				&& Objects.equals(name, other.name) && phoneNo == other.phoneNo;
	}

}
