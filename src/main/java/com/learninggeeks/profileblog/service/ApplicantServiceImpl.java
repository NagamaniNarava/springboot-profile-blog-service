package com.learninggeeks.profileblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learninggeeks.profileblog.dao.ApplicantDAO;
import com.learninggeeks.profileblog.entity.Applicant;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	private ApplicantDAO ApplicantDAO;
	@Override
	@Transactional
	public List<Applicant> getApplicants() {
		List<Applicant> Applicants = ApplicantDAO.getApplicants();
		return Applicants;
	}
	@Override
	@Transactional
	public void saveApplicant(Applicant theApplicant) {
		System.out.println("my:"+theApplicant);
		ApplicantDAO.saveApplicant(theApplicant);
	}
	@Override
	@Transactional
	public Applicant getApplicant(int id) {
		Applicant theApplicant = ApplicantDAO.getApplicant(id);
		return theApplicant;
	}
	@Override
	@Transactional
	public void deleteApplicant(int id) {
		ApplicantDAO.deleteApplicant(id);
	}

}
