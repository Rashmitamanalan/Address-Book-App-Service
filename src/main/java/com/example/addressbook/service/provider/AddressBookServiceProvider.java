package com.example.addressbook.service.provider;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.example.addressbook.model.Education;
import com.example.addressbook.model.User;
import com.example.addressbook.repository.EducationRepository;
import com.example.addressbook.repository.ExperienceRepository;
import com.example.addressbook.repository.UserRepository;
import com.example.addressbook.service.AddressBookService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AddressBookServiceProvider implements AddressBookService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EducationRepository educationRepository;
	
	@Autowired
	ExperienceRepository experienceRepository;
	
    @Value("${useMock}")
	protected boolean useMock;

	@Override
	public List<User> getAddressBook() {
		List<User> users= new ArrayList<User>();
		if(useMock) {
			try {
			      ClassPathResource classPathResource = new ClassPathResource("JsonMocks/people.json");
			      InputStream inputStream = classPathResource.getInputStream();
			      String fileContent = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
			      
			      ObjectMapper mapper = new ObjectMapper();
			      JsonNode rootNode = mapper.readValue(fileContent, JsonNode.class);
			      users = Arrays.asList(mapper.readValue(rootNode.toString(), User[].class));
			    } catch (Exception e) {
			      System.out.println(e);
			    }

			
		} else {
		users = userRepository.findAll();
		for(User u: users) {
			u.setEducation(educationRepository.findByUserId(u.getUserId()));
			u.setWorkExperience(experienceRepository.findByUserId(u.getUserId()));
		}
		}
		return users;
	}

}
