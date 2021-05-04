package com.codewithz.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithz.jpa.model.Review;

@Repository
public interface ReviewsRepository extends JpaRepository<Review, Integer>{

}
