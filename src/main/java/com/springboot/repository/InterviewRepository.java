package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.RaymondJamesInterview;

@Repository
public interface InterviewRepository extends CrudRepository<RaymondJamesInterview, Long> {

}
