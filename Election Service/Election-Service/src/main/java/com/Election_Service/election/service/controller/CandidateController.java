package com.Election_Service.election.service.controller;

import java.util.List;


import org.springframework.web.bind.annotation.*;

import com.Election_Service.election.service.dto.CandidateDTO;
import com.Election_Service.election.service.model.Candidate;
import com.Election_Service.election.service.service.CandidateService;
@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
	private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping
    public Candidate addCandidate(@RequestBody CandidateDTO candidateDTO) {
        return candidateService.addCandidate(candidateDTO);
    }

    @GetMapping("/{electionId}")
    public List<Candidate> getCandidatesByElection(@PathVariable Long electionId) {
        return candidateService.getCandidatesByElection(electionId);
    }
}
