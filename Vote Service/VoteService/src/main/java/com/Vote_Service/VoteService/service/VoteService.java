package com.Vote_Service.VoteService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Vote_Service.VoteService.dto.VoteDTO;
import com.Vote_Service.VoteService.model.Vote;
import com.Vote_Service.VoteService.repository.VoteRepository;


public interface VoteService {
    List<Vote> getAllVotes();
    Vote createVote(Vote vote);
    Vote getVoteById(Long id);
    void deleteVote(Long id);
    
    
}

