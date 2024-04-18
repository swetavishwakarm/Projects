package com.example.springbootstudentmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootstudentmanagementsystem.model.Department;
import com.example.springbootstudentmanagementsystem.repository.DepartmentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DepartmentService {
	@Autowired
	private  DepartmentRepository repo;
	
	public List< Department> listAll(){
		return repo.findAll();
		
	}
	
	public void save( Department department) {
		repo.save( department);
	}
	
	public  Department get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);

}
}