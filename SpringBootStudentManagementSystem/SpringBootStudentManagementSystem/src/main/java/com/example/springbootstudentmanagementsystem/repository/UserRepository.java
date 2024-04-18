package com.example.springbootstudentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootstudentmanagementsystem.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findUserByUserNameAndPassword(String userName, String password);

}
