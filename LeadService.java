package com.marketingapp1.service;

import java.util.List;

import com.marketingapp1.entity.Lead;

public interface LeadService {
 public void saveLead(Lead lead);

public List<Lead> getLeads();

public void deleteLead(long id);

public Lead getLeadById(long id);










}
