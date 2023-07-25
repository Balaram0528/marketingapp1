package com.marketingapp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp1.entity.Lead;
import com.marketingapp1.service.LeadService;
import com.marketingapp1.util.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadservice;
	
	
	@Autowired
	private EmailService emailservice;
	
	@RequestMapping("/view")
	private String viewleadpage() {
		return "create_table";
	}
	@RequestMapping("/saveLead")
 public String saveOneLead(Lead lead, Model model) {
		leadservice.saveLead(lead);
		emailservice.sendEmail(lead.getEmail(), "Welcome", "message");
		model.addAttribute("msg","Lead is saved!!");
	 return "create_table";
 }
	
	@RequestMapping("/listall")
	public String getAllLeads(Model model) {
	List<Lead>leads = leadservice.getLeads();
	model.addAttribute("leads",leads);

	return "list_leads";
	}
	@RequestMapping("/delete")
	public String deleteLeadById(@RequestParam("id")long id,ModelMap model) {
		leadservice.deleteLead(id);
		List<Lead>leads = leadservice.getLeads();
		model.addAttribute("leads",leads);
		return "list_leads";
	}
	@RequestMapping("/update")
	public String getLeadById(@RequestParam("id")long id , Model model) {
		Lead lead = leadservice.getLeadById(id);
		model.addAttribute("lead",lead);
		return "update_lead";
	}
		
		@RequestMapping("/updateLead")
		 public String updateOneLead(Lead lead, Model model) {
			leadservice.saveLead(lead);
			List<Lead>leads = leadservice.getLeads();
			model.addAttribute("leads",leads);
			return "list_leads";
				
	}
	
	
}