package com.learninggeeks.profileblog.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learninggeeks.profileblog.SaveRequest;
import com.learninggeeks.profileblog.entity.Applicant;
import com.learninggeeks.profileblog.entity.ApplicantSkills;
import com.learninggeeks.profileblog.exception.ApplicantNotFoundException;
import com.learninggeeks.profileblog.service.ApplicantService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ApplicantRestController {
	
	@Autowired
	private ApplicantService applicantservice;
	
	@GetMapping("/applicants")
	public List<SaveRequest> getApplicants() {
		
		List<Applicant> applicants = applicantservice.getApplicants();
		System.out.println("debug:"+applicants);
		
		if(applicants == null) {
			throw new ApplicantNotFoundException("Applicants not found");
		}
		List<SaveRequest> result = new ArrayList<>();
		applicants.stream().forEach(a->{
			SaveRequest sr = new SaveRequest();
			sr.setId(a.getId());
			sr.setEducation(a.getEducation());
			sr.setFirstName(a.getFirstName());
			sr.setLastName(a.getLastName());
			sr.setMailId(a.getMailId());
			sr.setPhoneNo(a.getPhoneNo());
			sr.setRole(a.getRole());
			sr.setSummary(a.getSummary());
			sr.setUserAuthenticateId(a.getUserAuthenticateId());
			StringBuffer sb = new StringBuffer();
			a.getApplicantSkills().forEach(sk->{
				sb.append(sk.getSkills());
				sb.append(", ");
			});
			if (sb!=null) {
			sr.setApplicantSkills(sb.toString().substring(0, sb.length() - 2));
			}
			result.add(sr);
		});
		return result;
	}
	
	@GetMapping("/applicant/{applicantId}")
	public Applicant getApplicant(@PathVariable int applicantId) {
		Applicant theApplicant = applicantservice.getApplicant(applicantId);
		if(theApplicant == null) {
			throw new ApplicantNotFoundException("Applicant not found");
		}
		return theApplicant;
	}
	
	@RequestMapping(value = "/applicants", headers = "Accept=application/json", method = RequestMethod.POST)
	public void saveApplicant(@RequestBody SaveRequest saveRequest) {
		System.out.println("I am printing :'" + saveRequest);
		Applicant theApplicant = new Applicant();
		theApplicant.setFirstName(saveRequest.getFirstName());
		theApplicant.setLastName(saveRequest.getLastName());
		theApplicant.setEducation(saveRequest.getEducation());
		theApplicant.setMailId(saveRequest.getMailId());
		theApplicant.setPhoneNo(saveRequest.getPhoneNo());
		theApplicant.setRole(saveRequest.getRole());
		theApplicant.setSummary(saveRequest.getSummary());
		theApplicant.setUserAuthenticateId(saveRequest.getUserAuthenticateId());
		theApplicant.setCreateDate(new Timestamp(new Date().getTime()));
		
		List<ApplicantSkills> list = new ArrayList<>();
		Arrays.stream(saveRequest.getApplicantSkills().split(",")).forEach(s->{
																		ApplicantSkills	as = new ApplicantSkills();
																		as.setSkills(s);
																		as.setCreateDate(new Timestamp(new Date().getTime()));
																		as.setApplicant(theApplicant);
																		list.add(as);
																		});
		
		theApplicant.setApplicantSkills(list);
		System.out.println(theApplicant);
		applicantservice.saveApplicant(theApplicant);
	}
	
	@RequestMapping(value = "/applicant/edit", headers = "Accept=application/json", method = RequestMethod.POST)
	public void updateApplicant(@RequestBody Applicant theApplicant) {
		applicantservice.saveApplicant(theApplicant);
	}

	@PostMapping("/applicant/delete/{applicantId}")
	public void deleteApplicant(@PathVariable int applicantId) {
		applicantservice.deleteApplicant(applicantId);
	}
}