package com.Election_Service.election.service.service;

import java.util.List;

import com.Election_Service.election.service.dto.CandidateDTO;
import com.Election_Service.election.service.model.Candidate;

public interface CandidateServiceInterface {
	 Candidate addCandidate(CandidateDTO candidateDTO);
	    List<Candidate> getCandidatesByElection(Long electionId);
}
