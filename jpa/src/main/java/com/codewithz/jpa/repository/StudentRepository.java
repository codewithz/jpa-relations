package com.codewithz.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codewithz.jpa.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query("Select s from Student s")
	List<Student> loadStudentByQuery();
	
	@Query("Select s from Student s where s.id=:id")
	Student loadStudentById(int id);
	
	@Query("Select s from Student s where s.passport.number=:name")
	Student loadStudentByPassport(String name);
	
}
