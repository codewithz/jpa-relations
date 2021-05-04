package com.codewithz.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewithz.jpa.model.Passport;
import com.codewithz.jpa.model.Student;
import com.codewithz.jpa.repository.PassportRepository;
import com.codewithz.jpa.repository.StudentRepository;

@RestController
public class StudentController 
{
	@Autowired
	StudentRepository repository;
	
	@Autowired
	PassportRepository passportRepository;
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id)
	{
		Student s=repository.findById(id).get();
		//Student s=repository.getOne(id);
		Passport p=s.getPassport();
		System.out.println(p);
		return s;
	}
	
	@GetMapping("/studentByQuery/{id}")
	public Student getStudentByQueryId(@PathVariable int id)
	{
		Student s=repository.loadStudentById(id);
		return s;
	}
	
	@GetMapping("/studentByPassport/{number}")
	public Student getStudentByPassport(@PathVariable String number)
	{
		Student s=repository.loadStudentByPassport(number);
		return s;
	}
	
	@GetMapping("/passport/{id}")
	public ResponseEntity<Passport> getPassportById(@PathVariable int id)
	{
		Passport p=passportRepository.findById(id).get();
		ResponseEntity<Passport> entity=new ResponseEntity<Passport>(p,HttpStatus.OK);
		return entity;
	}

}
