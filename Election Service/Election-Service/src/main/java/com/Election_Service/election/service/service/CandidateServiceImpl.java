package com.Election_Service.election.service.service;

import com.Election_Service.election.service.dto.CandidateDTO;
import com.Election_Service.election.service.model.Candidate;
import com.Election_Service.election.service.model.Election;
import com.Election_Service.election.service.repository.CandidateRepository;
import com.Election_Service.election.service.repository.ElectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateServiceInterface {

    private final CandidateRepository candidateRepository;
    private final ElectionRepository electionRepository;

    public CandidateServiceImpl(CandidateRepository candidateRepository, ElectionRepository electionRepository) {
        this.candidateRepository = candidateRepository;
        this.electionRepository = electionRepository;
    }

    @Override
    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found with ID: " + id));
    }

    @Override
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

    @Override
    public List<Candidate> getCandidatesByElection(Long electionId) {
        return candidateRepository.findByElectionId(electionId);
    }

    @Override
    public Candidate voteForCandidate(Long candidateId) {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
        candidate.setVotes(candidate.getVotes() + 1);
        return candidateRepository.save(candidate);
    }

    @Override
    public int getCandidateVotes(Long candidateId) {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
        return candidate.getVotes();
    }
}
