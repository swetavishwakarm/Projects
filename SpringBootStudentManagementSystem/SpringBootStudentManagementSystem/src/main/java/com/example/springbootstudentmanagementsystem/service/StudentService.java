package com.example.springbootstudentmanagementsystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootstudentmanagementsystem.model.Student;
import com.example.springbootstudentmanagementsystem.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentRepository repo;
	
	public List<Student> listAll(){
		return repo.findAll();
		
	}
	
	public void save(Student student) {
		repo.save(student);
	}
	
	public Student get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
	
	public List<String> findAllStudentNames() {
		
	
		List<Student> students = repo.findAll();
		List<String> studNames = students.stream()
				.map(Student::getName)
				.collect(Collectors.toList());
		
		return studNames;
	}
	
}


