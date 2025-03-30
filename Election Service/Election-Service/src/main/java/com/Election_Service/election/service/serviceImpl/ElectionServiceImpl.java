package com.Election_Service.election.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Election_Service.election.service.dto.ElectionDTO;
import com.Election_Service.election.service.exception.ResourceNotFoundException;
import com.Election_Service.election.service.model.Election;
import com.Election_Service.election.service.repository.ElectionRepository;
import com.Election_Service.election.service.service.ElectionServiceInterface;

@Service
public class ElectionServiceImpl implements ElectionServiceInterface {

    private final ElectionRepository electionRepository;

    public ElectionServiceImpl(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    @Override
    public Election createElection(ElectionDTO electionDTO) {
        Election election = Election.builder()
                .name(electionDTO.getName())
                .startDate(electionDTO.getStartDate())
                .endDate(electionDTO.getEndDate())
                .isActive(true)
                .build();
        return electionRepository.save(election);
    }

    @Override
    public List<Election> getAllElections() {
        return electionRepository.findAll();
    }

    @Override
    public Election getElectionById(Long electionId) {
        return electionRepository.findById(electionId)
                .orElseThrow(() -> new ResourceNotFoundException("Election not found with ID: " + electionId));
    }
}
