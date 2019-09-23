package com.example.demo.service;


import java.util.List;


import com.example.demo.model.Student;

/**
 * The Interface UserService provide the services in the application.
 * 
 * @author Aman Gautam
 * 
 * Dated :21/9/19
 */
public interface UserService {
    
    /**
     * Creates the user.
     *
     * @param user the user
     */
    public void createUser(Student user);
    
    /**
     * Gets the user.
     *
     * @return the user
     */
    public List<Student> getUser();
    
    /**
     * Gets the by email.
     *
     * @param email the email
     * @return the by email
     */
    public Student getByEmail(String email);
}