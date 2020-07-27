package com.learninggeeks.profileblog.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learninggeeks.profileblog.entity.Applicant;

@Repository
public class ApplicantDAOImpl implements ApplicantDAO {

	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public ApplicantDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Applicant> getApplicants() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Applicant> theQuery = currentSession.createQuery("from Applicant",Applicant.class);
		List<Applicant> Applicants = theQuery.getResultList();
		return Applicants;
	}

	@Override
	public void saveApplicant(Applicant theApplicant) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theApplicant);
	}

	@Override
	public Applicant getApplicant(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Applicant theApplicant = currentSession.get(Applicant.class, id);
		return theApplicant;
	}

	@Override
	public void deleteApplicant(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from Applicant where id=:ApplicantId");
		theQuery.setParameter("ApplicantId", id);
		theQuery.executeUpdate();
	}
}
