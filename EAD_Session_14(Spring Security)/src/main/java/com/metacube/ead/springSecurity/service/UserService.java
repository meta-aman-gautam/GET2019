package com.metacube.ead.springSecurity.service;

import java.util.List;
import com.metacube.ead.springSecurity.model.Student;

/**
 * The Interface UserService to provide service to client request.
 * 
 * @author Aman Gautam
 * 
 * Dated:23/9/19
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