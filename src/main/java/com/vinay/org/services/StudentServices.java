/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.services;

import com.vinay.org.entity.Student;
import com.vinay.org.exception.InvalidPasswordException;

/**
 *
 * @author vinay
 */
public interface StudentServices {

    public static final Integer ADMIN_ROLE = 1;
    public static final Integer USER_ROLE = 2;

    public Student login(String username, String password) throws InvalidPasswordException;
}
