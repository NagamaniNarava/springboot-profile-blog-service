package com.learninggeeks.profileblog;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveRequest {
	
	    @JsonProperty
	    private int id;
	
		@JsonProperty
		private String firstName;
		
		@JsonProperty
		private String lastName;
		
		@JsonProperty
		private String role;
		
		@JsonProperty
		private String summary;
		
		@JsonProperty
		private String education;
		
		@JsonProperty
		private String phoneNo;
		
		@JsonProperty
		private String mailId;
		
		@JsonProperty
		private String userAuthenticateId;
		
		@JsonProperty
		private String applicantSkills;
		
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

		public String getApplicantSkills() {
			return applicantSkills;
		}

		public void setApplicantSkills(String applicantSkills) {
			this.applicantSkills = applicantSkills;
		}

		@Override
		public String toString() {
			return "SaveRequest [firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + ", summary="
					+ summary + ", education=" + education + ", phoneNo=" + phoneNo + ", mailId=" + mailId
					+ ", userAuthenticateId=" + userAuthenticateId + ", applicantSkills=" + applicantSkills + "]";
		}
		
}
