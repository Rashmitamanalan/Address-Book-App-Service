package com.example.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.addressbook.model.WorkExperience;

public interface ExperienceRepository extends JpaRepository<WorkExperience, Long>{
	List<WorkExperience> findByUserId(int id);

}
