package com.Vote_Service.VoteService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Vote_Service.VoteService.dto.VoteDTO;
import com.Vote_Service.VoteService.exception.VoteNotFoundException;
import com.Vote_Service.VoteService.model.Vote;
import com.Vote_Service.VoteService.service.VoteService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("api/votes")
@CrossOrigin(origins = "*")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @GetMapping
    public ResponseEntity<List<Vote>> getAllVotes() {
        return ResponseEntity.ok(voteService.getAllVotes());
    }

    @PostMapping
    public ResponseEntity<Vote> createVote(@Valid @RequestBody VoteDTO voteDTO) {
        Vote vote = Vote.builder()
                .voterId(voteDTO.getVoterId())
                .candidateId(voteDTO.getCandidateId())
                .electionId(voteDTO.getElectionId())
                .build();

        return new ResponseEntity<>(voteService.createVote(vote), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vote> getVoteById(@PathVariable Long id) {
        return ResponseEntity.ok(voteService.getVoteById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVote(@PathVariable Long id) {
        voteService.deleteVote(id);
        return ResponseEntity.noContent().build();
    }
}