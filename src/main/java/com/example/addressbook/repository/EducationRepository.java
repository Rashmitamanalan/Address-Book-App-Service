package com.example.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.addressbook.model.Education;

public interface EducationRepository extends JpaRepository<Education, Long>{
	
	List<Education> findByUserId(int id);
	
	List<Education> findAll();

}
