package com.metacube.ead.assignment.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import com.metacube.ead.assignment.entity.Student;

/**
 * The Class StudentDao. which acts as hibernate template layout 
 * 
 * @author Aman Gautam
 * 
 * Dated : 18/9/19
 */
@Transactional
@Component
public class StudentDao {

	@Autowired
	HibernateTemplate template;

	/**
	 * Adds the student to database.
	 *
	 * @param student
	 */
	public boolean addStudent(Student student) {
		boolean value = false;
		try{
			template.save(student);
			value =true;
		}
		catch(Exception e){
			e.getMessage();
		}
		return value;
	}

	/**
	 * Show student to database.
	 *
	 * @return the list
	 */
	public List<Student> showStudent() {
		return template.loadAll(Student.class);
	}
	
}
