package com.example.addressbook.repository;

import java.util.List;
import com.example.addressbook.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	List<User> findAll();

}
