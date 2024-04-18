package com.example.springbootstudentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootstudentmanagementsystem.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
