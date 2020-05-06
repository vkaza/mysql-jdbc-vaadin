package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Interview;

@Repository
public interface InterviewRepository extends CrudRepository<Interview, Long> {

}
