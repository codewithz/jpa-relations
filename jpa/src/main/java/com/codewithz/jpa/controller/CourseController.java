package com.codewithz.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewithz.jpa.dto.CourseReviewDTO;
import com.codewithz.jpa.model.Course;
import com.codewithz.jpa.model.Review;
import com.codewithz.jpa.repository.CourseRepository;
import com.codewithz.jpa.repository.ReviewsRepository;

@RestController
public class CourseController 
{
	@Autowired
	CourseRepository repository;
	
	@Autowired
	ReviewsRepository reviewRepo;
	
	@PostMapping("/course")
	public String addCourse(@RequestBody Course c)
	{
		Course addedCourse=repository.save(c);
		if(addedCourse!=null)
		{
			return "Success";
		}
		else
		{
			return "Failure";
		}
	}
	
	@PostMapping("/course/review/{id}")
	public String addReviewForCourse(@PathVariable int id,@RequestBody Review r)
	{
		Course c=repository.findById(id).get();
		c.addReview(r);
		r.setCourse(c);
		
		reviewRepo.save(r);
		return "Success";
		
	}
	
	@GetMapping("/course/{id}")
	public Course getCourse(@PathVariable int id)
	{
		Course c=repository.findById(id).get();
		return c;
	}
	
	@GetMapping("/courseReviews")
	public List<CourseReviewDTO> getCourseReviews()
	{
		List<CourseReviewDTO> list=repository.getReviewsForCourse();
		return list;
	}
}
