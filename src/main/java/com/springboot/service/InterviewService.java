package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.RaymondJamesInterview;
import com.springboot.repository.InterviewRepository;

@Service
@Transactional
public class InterviewService{

	
	@Autowired
	private InterviewRepository interviewRepository;
	
	  public List<RaymondJamesInterview> getAllInterviews() { 
		  List<RaymondJamesInterview> raymondJamesInterviews = new ArrayList<>();
		  interviewRepository.findAll().forEach(raymondJamesInterviews::add);
		  return raymondJamesInterviews;
		  }
	  
	  public RaymondJamesInterview findInterviewerByID(Long id) {
		  return interviewRepository.findOne(id);
	  }
    
	  
	  public RaymondJamesInterview saveorUpdateInterviewer(RaymondJamesInterview raymondJamesInterview) {
		  return interviewRepository.save(raymondJamesInterview);
	  }
}
