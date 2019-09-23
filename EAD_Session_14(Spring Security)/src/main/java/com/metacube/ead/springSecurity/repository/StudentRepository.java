package com.metacube.ead.springSecurity.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.metacube.ead.springSecurity.model.Student;

/**
 * The Interface StudentRepository to provide a method of to search student by email.
 * 
 * @author Aman Gautam
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

	 /**
 	 * Find by email method
 	 *
 	 * @param email the email
 	 * @return the student
 	 */
 	//@Query("SELECT * FROM detail AS c WHERE c.email =email")
	  Student findByEmail(String email);
	
}
