package com.example.springbootstudentmanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	private int passingyear;
	private Double percentage;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student selectedStudent;


	public Department() {
		super();
	}


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




	public int getPassingyear() {
		return passingyear;
	}


	public void setPassingyear(int passingyear) {
		this.passingyear = passingyear;
	}


	public Double getPercentage() {
		return percentage;
	}


	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}


	public Student getSelectedStudent() {
		return selectedStudent;
	}


	public void setSelectedStudent(Student selectedStudent) {
		this.selectedStudent = selectedStudent;
	}


	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name +  ", passingyear="+ passingyear + ", percentage=" + percentage + ", selectedStudent=" + selectedStudent + "]";
	}


	
	

}
