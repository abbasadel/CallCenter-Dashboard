/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.shuratech.gis.api.service;

import com.shuratech.gis.api.model.Audit;
import java.util.List;

/**
 *
 * @author abbas
 */
public interface AuditService {
    
    public void add(Audit audit);
    
    public List<Audit> getAll();
    
}
