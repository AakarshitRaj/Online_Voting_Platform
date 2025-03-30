package com.Election_Service.election.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Election_Service.election.service.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {
	List<Candidate> findByElectionId(Long electionId);
}
