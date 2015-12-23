/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.shuratech.gis.api;

import java.util.List;

/**
 *
 * @author abbas
 * @param <T>
 * @param <IDTYPE> type of model id. String or Long
 */
public interface CRUDInterface<T, IDTYPE> {
	
    
    List<T> getAll();
    T get(IDTYPE id);
    T create(T t);
    T update(T t);
    boolean delete(IDTYPE id);
    
    
    
}
