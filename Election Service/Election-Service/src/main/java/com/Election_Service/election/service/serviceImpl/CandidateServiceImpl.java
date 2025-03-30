package com.Election_Service.election.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Election_Service.election.service.dto.CandidateDTO;
import com.Election_Service.election.service.model.Candidate;
import com.Election_Service.election.service.model.Election;
import com.Election_Service.election.service.repository.CandidateRepository;
import com.Election_Service.election.service.repository.ElectionRepository;
import com.Election_Service.election.service.service.CandidateServiceInterface;

@Service
public class CandidateServiceImpl implements CandidateServiceInterface{  // ✅ Implements the interface

    private final CandidateRepository candidateRepository;
    private final ElectionRepository electionRepository;

    public CandidateServiceImpl(CandidateRepository candidateRepository, ElectionRepository electionRepository) {
        this.candidateRepository = candidateRepository;
        this.electionRepository = electionRepository;
    }

    @Override
    public Candidate addCandidate(CandidateDTO candidateDTO) {
        Election election = electionRepository.findById(candidateDTO.getElectionId())
                .orElseThrow(() -> new RuntimeException("Election not found"));

        Candidate candidate = Candidate.builder()
                .name(candidateDTO.getName())
                .party(candidateDTO.getParty())
                .election(election)
                .votes(0)  // Default votes = 0
                .build();

        return candidateRepository.save(candidate);
    }

    @Override
    public List<Candidate> getCandidatesByElection(Long electionId) {
        return candidateRepository.findByElectionId(electionId);
    }
}
