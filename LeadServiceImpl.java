package com.marketingapp1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp1.entity.Lead;
import com.marketingapp1.repository.LeadRepo;
@Service
public class LeadServiceImpl implements LeadService {
	
	@Autowired
	private LeadRepo leadRepo;

	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);

	}

	@Override
	public List<Lead> getLeads() {
		List<Lead>leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public void deleteLead(long id) {
		leadRepo.deleteById(id);
		
	}

	@Override
	public Lead getLeadById(long id) {
		
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}
	
	
	}
	

	
	


