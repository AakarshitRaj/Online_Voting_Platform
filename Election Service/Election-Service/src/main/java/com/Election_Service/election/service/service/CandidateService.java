package com.Election_Service.election.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Election_Service.election.service.dto.CandidateDTO;
import com.Election_Service.election.service.exception.CandidateNotFoundException;
import com.Election_Service.election.service.model.Candidate;
import com.Election_Service.election.service.model.Election;
import com.Election_Service.election.service.repository.CandidateRepository;
import com.Election_Service.election.service.repository.ElectionRepository;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final ElectionRepository electionRepository;

    public CandidateService(CandidateRepository candidateRepository, ElectionRepository electionRepository) {
        this.candidateRepository = candidateRepository;
        this.electionRepository = electionRepository;
    }

    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("Candidate not found with ID: " + id));
    }

    public Candidate addCandidate(CandidateDTO candidateDTO) {
        Election election = electionRepository.findById(candidateDTO.getElectionId())
                .orElseThrow(() -> new RuntimeException("Election not found"));

        Candidate candidate = Candidate.builder()
                .name(candidateDTO.getName())
                .party(candidateDTO.getParty())
                .election(election)
                .votes(0)
                .build();

        return candidateRepository.save(candidate);
    }

    public List<Candidate> getCandidatesByElection(Long electionId) {
        return candidateRepository.findByElectionId(electionId);
    }

    public Candidate voteForCandidate(Long candidateId) {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
        candidate.setVotes(candidate.getVotes() + 1);
        return candidateRepository.save(candidate);
    }

    public int getCandidateVotes(Long candidateId) {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
        return candidate.getVotes();
    }
}
