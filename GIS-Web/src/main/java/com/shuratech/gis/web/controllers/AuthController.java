/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shuratech.gis.web.controllers;

import com.shuratech.gis.api.exceptions.UserNotFoundException;
import com.shuratech.gis.api.model.User;
import com.shuratech.gis.api.service.AuthService;
import com.shuratech.gis.web.response.JsonResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author abbas
 */
@Controller
public class AuthController {

    Logger logger = Logger.getLogger(AuthController.class);

    @Autowired
    AuthService authService;
//
//    @RequestMapping(value = "/auth", method = RequestMethod.POST, headers = {"content-type=application/json"})
//    public @ResponseBody
//    JsonResponse login(@RequestBody User user) {
//        try {
//            User foundUser = authService.authenticate(user.getUsername(), user.getPassword());
//        } catch (UserNotFoundException ex) {
//            logger.error("User " + user.getUsername() + " not found", ex);
//            return JsonResponse.make("Incorrent username or password", HttpStatus.FORBIDDEN);
//        }
//
//        return JsonResponse.make("Authenticated Successfully");
//    }

    @RequestMapping(value = "/who", method = RequestMethod.GET)

    public @ResponseBody
    org.springframework.security.core.userdetails.User who() {
        return  (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    }

}
