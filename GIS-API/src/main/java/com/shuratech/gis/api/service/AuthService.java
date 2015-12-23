package com.shuratech.gis.api.service;

import com.shuratech.gis.api.exceptions.UserNotFoundException;
import com.shuratech.gis.api.model.User;

/**
 *
 * @author abbas
 */
public interface AuthService {
    /**
     * Authenticate username and password against another system
     * @param username
     * @param password
     * @return User if found, else throws UserNotFoundException
     * @throws com.shuratech.gis.api.exceptions.UserNotFoundException
     */
    User authenticate(String username, String password) throws UserNotFoundException;
    
    /**
     * search for user by username
     * @param username
     * @return User or null if not found
     */
    
    User getUserByUsername(String username);
}
