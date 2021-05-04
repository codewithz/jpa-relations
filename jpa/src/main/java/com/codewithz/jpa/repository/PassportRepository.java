package com.codewithz.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithz.jpa.model.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Integer>{

}
