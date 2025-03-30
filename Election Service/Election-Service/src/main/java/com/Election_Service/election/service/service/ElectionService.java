package com.Election_Service.election.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Election_Service.election.service.dto.ElectionDTO;
import com.Election_Service.election.service.model.Election;
import com.Election_Service.election.service.repository.ElectionRepository;

@Service
public class ElectionService {
	
	private final ElectionRepository electionRepository;
	

	public ElectionService(ElectionRepository electionRepository) {
		this.electionRepository = electionRepository;
	}


	public Election createElection(ElectionDTO electionDTO) {
		Election election =Election.builder()
				.name(electionDTO.getName())
				.startDate(electionDTO.getStartDate())
				.endDate(electionDTO.getEndDate())
				.isActive(true)
				.build();
		return electionRepository.save(election);
	}


	public List<Election> getAllElections() {
		return electionRepository.findAll();
	}

}
