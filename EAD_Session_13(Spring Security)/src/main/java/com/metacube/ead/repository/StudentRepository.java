package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.example.demo.model.Student;

/**
 * The Interface StudentRepository is used to define the method of JPA_repository.
 * 
 * @author Aman Gautam
 * 
 * Dated:23/9/19
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

	 /**
 	 * Find by email.
 	 *
 	 * @param email the email
 	 * @return the student
 	 */
 	//@Query("SELECT * FROM detail AS c WHERE c.email =email")
	  Student findByEmail(String email);
}
