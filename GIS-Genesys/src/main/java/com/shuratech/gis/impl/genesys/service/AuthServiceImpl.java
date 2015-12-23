/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shuratech.gis.impl.genesys.service;

import com.shuratech.gis.api.exceptions.UserNotFoundException;
import com.shuratech.gis.api.model.User;
import com.shuratech.gis.api.service.AuthService;

/**
 *
 * @author abbas
 */
public class AuthServiceImpl implements AuthService {

    @Override
    public User authenticate(String username, String password) throws UserNotFoundException {
        return new User(username, null);
    }

    @Override
    public User getUserByUsername(String username) {
        return new User(username, null);
    }

}
