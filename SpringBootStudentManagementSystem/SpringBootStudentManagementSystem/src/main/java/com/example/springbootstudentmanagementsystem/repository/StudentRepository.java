package com.example.springbootstudentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootstudentmanagementsystem.model.Student;

public interface StudentRepository  extends JpaRepository<Student, Long>{

}