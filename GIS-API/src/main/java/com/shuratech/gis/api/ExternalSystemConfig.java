/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.shuratech.gis.api;

import java.util.Map;

/**
 *
 * @author abbas
 */
public interface ExternalSystemConfig {
    
    String getUsername();
    String getPassword();
    String getURL();
    Object get(String key);
    
}
