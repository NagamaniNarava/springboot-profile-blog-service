package com.learninggeeks.profileblog.dao;

import java.util.List;

import com.learninggeeks.profileblog.entity.Applicant;

public interface ApplicantDAO {
	
	public List<Applicant> getApplicants();
	public Applicant getApplicant(int id);
	public void saveApplicant(Applicant theCustomer);
	public void deleteApplicant(int id);

}
