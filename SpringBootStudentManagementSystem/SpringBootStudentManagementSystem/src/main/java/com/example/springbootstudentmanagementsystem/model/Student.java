package com.example.springbootstudentmanagementsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="student_id")
	long id ;
	private String name;
   private String clgname;
   private String city;
   private Long phoneno;
  private String address;
public Student() {
	super();
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getClgname() {
	return clgname;
}
public void setClgname(String clgname) {
	this.clgname = clgname;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public Long getPhoneno() {
	return phoneno;
}
public void setPhoneno(Long phoneno) {
	this.phoneno = phoneno;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", clgname=" + clgname + ", city=" + city + ", phoneno=" + phoneno
			+ ", address=" + address + "]";
}
} 
  