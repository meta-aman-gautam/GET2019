package com.metacube.ead.assignment.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.metacube.ead.assignment.entity.Student;

/**
 * StudentRepository is the very special inteface which extends JpaRepository
 * to execute jpa queries in the spring using hibernate
 *  
 * @author Aman Gautam
 * 
 * Dated :19/9/19
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	/**
	 * findByEmailContainingIgnoreCase() method helps to get find the student row with the email 
	 * 
	 * @param string
	 * @return
	 */
	public List<Student> findByEmailContainingIgnoreCase(String string) ;
	
	/**
	 * findAll() method is used to get all the content of the table
	 */
	public List<Student> findAll();
	
	/**
	 * insertStudent() method is the replacement of insertintoQuery statement 
	 * 
	 * @param age
	 * @param email
	 * @param fatherName
	 * @param firstName
	 * @param lastName
	 * @param studentClass
	 * @return
	 */
	@Transactional
        @Modifying
        @Query(value ="Insert into student (age ,email,fatherName,firstName ,lastName,studentClass) Values (:age,:email,:fatherName,:firstName,:lastName,:studentClass)",nativeQuery = true)
        public int insertStudent(@Param("age")Integer age, @Param("email")String email,@Param("fatherName") String fatherName,@Param("firstName")String firstName,@Param("lastName")String lastName,@Param("studentClass")Integer studentClass);	
	
}
