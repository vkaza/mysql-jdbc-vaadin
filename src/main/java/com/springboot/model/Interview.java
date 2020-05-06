package com.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INTERVIEW")
public class Interview {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "INTERVIEW_START_TIME")
	private Date interviewStartTime;

	@Column(name = "INTERVIEW_END_TIME")
	private Date interviewEndTime;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "HOW_ARE_YOU")
	private String howAreYou;

	
	protected Interview() {
	}

	public Interview(Date interviewStartTime, Date interviewEndTime, String firstName, String lastName,
			String title, String howAreYou) {
		this.interviewStartTime = interviewStartTime;
		this.interviewEndTime = interviewEndTime;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.howAreYou = howAreYou;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInterviewStartTime() {
		return interviewStartTime;
	}

	public void setInterviewStartTime(Date interviewStartTime) {
		this.interviewStartTime = interviewStartTime;
	}

	public Date getInterviewEndTime() {
		return interviewEndTime;
	}

	public void setInterviewEndTime(Date interviewEndTime) {
		this.interviewEndTime = interviewEndTime;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHowAreYou() {
		return howAreYou;
	}

	public void setHowAreYou(String howAreYou) {
		this.howAreYou = howAreYou;
	}
	
	@Override
	public String toString() {
		return String.format("Interviewer[id=%d, firstName='%s', lastName='%s', title=%s, startTime=%s, endime=%s]", id,
				firstName, lastName, title, interviewStartTime.toString(), interviewEndTime.toString());
	}

}
