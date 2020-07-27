package com.learninggeeks.profileblog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name="applicant")
public class Applicant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="role")
	private String role;
	
	@Column(name="summary")
	private String summary;
	
	@Column(name="education")
	private String education;
	
	@Column(name="phoneNo")
	private String phoneNo;
	
	@Column(name="mailId")
	private String mailId;
	
	@Column(name="userAuthenticateId")
	private String userAuthenticateId;
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createDate")
	private Date createDate;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "applicant")
	@Cascade({CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	private List<ApplicantSkills> applicantSkills = new ArrayList<ApplicantSkills>();
	
	
	public List<ApplicantSkills> getApplicantSkills() {
		return applicantSkills;
	}

	public void setApplicantSkills(List<ApplicantSkills> applicantSkills) {
		this.applicantSkills = applicantSkills;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getUserAuthenticateId() {
		return userAuthenticateId;
	}

	public void setUserAuthenticateId(String userAuthenticateId) {
		this.userAuthenticateId = userAuthenticateId;
	}
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Applicant [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role
				+ ", summary=" + summary + ", education=" + education + ", phoneNo=" + phoneNo
				+ ", mailId=" + mailId + ", profileImageUrl=" + ", userAuthenticateId=" + userAuthenticateId + ", createDate=" + createDate +"]";
	}
}
