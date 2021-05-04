package com.codewithz.jpa.dto;

public class CourseReviewDTO 
{
	String courseName;
	String review;
	
	
	public CourseReviewDTO(String courseName, String review) {
		super();
		this.courseName = courseName;
		this.review = review;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	

}
