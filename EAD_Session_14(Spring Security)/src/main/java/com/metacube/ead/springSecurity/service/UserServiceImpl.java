package com.metacube.ead.springSecurity.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.ead.springSecurity.model.Student;
import com.metacube.ead.springSecurity.repository.StudentRepository;


/**
 * The Class UserServiceImpl is used to provide implementation of the 
 * user service 
 * 
 * @author Aman Gautam
 * 
 * Dated :23/9/19
 */
@Service
@Transactional
public class UserServiceImpl implements UserService  {
	
	
	/** The student repository. */
	@Autowired
	private StudentRepository studentRepository;


	@Override
	public void createUser(Student user) {
		studentRepository.save(user);
		
	}

	@Override
	public List<Student> getUser() {
		return studentRepository.findAll();
	}

	@Override
	public Student getByEmail(String email) {
				return studentRepository.findByEmail(email);
	}

}
