package com.codewithz.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codewithz.jpa.dto.CourseReviewDTO;
import com.codewithz.jpa.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	@Query("Select new com.codewithz.jpa.dto.CourseReviewDTO(c.name,r.review) from Course c JOIN Review r ON c.id=r.course.id")
	public List<CourseReviewDTO> getReviewsForCourse();
	
	

}
