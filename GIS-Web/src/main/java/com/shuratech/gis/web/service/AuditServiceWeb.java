package com.shuratech.gis.web.service;

import com.shuratech.gis.api.model.Audit;
import com.shuratech.gis.api.service.AuditService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abbas
 */
public class AuditServiceWeb implements AuditService{
    
    private static List<Audit> audits = new ArrayList<Audit>();

    @Override
    public void add(Audit audit) {
        audits.add(audit);
    }

    @Override
    public List<Audit> getAll() {
        return audits;
    }
    
}
