package com.Vote_Service.VoteService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vote_Service.VoteService.client.CandidateClient;
import com.Vote_Service.VoteService.dto.CandidateDTO;
import com.Vote_Service.VoteService.exception.VoteNotFoundException;
import com.Vote_Service.VoteService.model.Vote;
import com.Vote_Service.VoteService.repository.VoteRepository;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private CandidateClient candidateClient;  // Inject the REST client

    @Override
    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    @Override
    public Vote createVote(Vote vote) {
        // Validate candidate exists and belongs to the correct election
        CandidateDTO candidate = candidateClient.getCandidateById(vote.getCandidateId());

        if (candidate == null || !candidate.getElectionId().equals(vote.getElectionId())) {
            throw new RuntimeException("Invalid candidate or mismatched election.");
        }

        System.out.println("Voted for: " + candidate.getName());

        return voteRepository.save(vote);
    }

    @Override
    public Vote getVoteById(Long id) {
        return voteRepository.findById(id)
                .orElseThrow(() -> new VoteNotFoundException("Vote not found with ID: " + id));
    }

    @Override
    public void deleteVote(Long id) {
        voteRepository.deleteById(id);
    }
}
