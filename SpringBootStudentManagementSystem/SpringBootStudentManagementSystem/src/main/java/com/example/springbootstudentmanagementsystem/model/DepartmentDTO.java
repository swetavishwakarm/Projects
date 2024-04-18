package com.example.springbootstudentmanagementsystem.model;

public class DepartmentDTO {
	private Long id;
	private String name;
	private Long studentid;
	private int passingyear;
	private Double percentage;
	public DepartmentDTO() {
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
	public Long getStudentid() {
		return studentid;
	}
	public void setStudentid(Long studentid) {
		this.studentid = studentid;
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
	@Override
	public String toString() {
		return "DepartmentDTO [id=" + id + ", name=" + name + ", studentid=" + studentid + ", passingyear="
				+ passingyear + ", percentage=" + percentage + "]";
	}
	
	
	
	
}