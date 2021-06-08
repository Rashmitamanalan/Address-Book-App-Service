package com.example.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.addressbook.model.User;
import com.example.addressbook.service.AddressBookService;

@RestController
@RequestMapping("/api")
public class AddressBookController {
	@Autowired
	AddressBookService addressBookService;
	
	@GetMapping("/people")
	public List<User> getPeople(){
		System.out.println("Controller is hit");
		return addressBookService.getAddressBook();
		
	}
}
