package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.Interview;
import com.springboot.repository.InterviewRepository;

@Service
@Transactional
public class InterviewService{

	
	@Autowired
	private InterviewRepository interviewRepository;
	
	  public List<Interview> getAllInterviews() { 
		  List<Interview> interviews = new ArrayList<>();
		  interviewRepository.findAll().forEach(interviews::add);
		  return interviews;
		  }
	  
	  public Interview findInterviewerByID(Long id) {
		  return interviewRepository.findOne(id);
	  }
    
	  
	  public Interview saveorUpdateInterviewer(Interview interview) {
		  return interviewRepository.save(interview);
	  }
}
