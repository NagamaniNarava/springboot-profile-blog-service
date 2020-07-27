package com.learninggeeks.profileblog.service;

import java.util.List;

import com.learninggeeks.profileblog.entity.Applicant;

public interface ApplicantService {
	public List<Applicant> getApplicants();
	public Applicant getApplicant(int id);
	public void saveApplicant(Applicant theApplicant);
	public void deleteApplicant(int id);
}
