package com.Election_Service.election.service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Election_Service.election.service.dto.CandidateDTO;
import com.Election_Service.election.service.model.Candidate;
import com.Election_Service.election.service.service.CandidateService;
import com.Election_Service.election.service.mapper.CandidateMapper;

@RestController
@RequestMapping("/api/candidate")
@CrossOrigin(origins = "*")
public class CandidateController {

    private final CandidateService candidateService;
    private final CandidateMapper candidateMapper;

    public CandidateController(CandidateService candidateService, CandidateMapper candidateMapper) {
        this.candidateService = candidateService;
        this.candidateMapper = candidateMapper;
    }

    // ✅ Add Candidate
    @PostMapping
    public Candidate addCandidate(@RequestBody CandidateDTO candidateDTO) {
        return candidateService.addCandidate(candidateDTO);
    }

    // ✅ Get All Candidates for a Given Election
    @GetMapping("/election/{electionId}")
    public List<Candidate> getCandidatesByElection(@PathVariable Long electionId) {
        return candidateService.getCandidatesByElection(electionId);
    }

    // ✅ Get Candidate by ID (used by VoteService)
    @GetMapping("/id/{id}")
    public ResponseEntity<CandidateDTO> getCandidateById(@PathVariable Long id) {
        Candidate candidate = candidateService.getCandidateById(id);
        CandidateDTO dto = candidateMapper.toDTO(candidate);
        return ResponseEntity.ok(dto);
    }

    // ✅ Cast Vote for a Candidate
    @PutMapping("/vote/{candidateId}")
    public Candidate voteForCandidate(@PathVariable Long candidateId) {
        return candidateService.voteForCandidate(candidateId);
    }

    // ✅ Get Vote Count for a Candidate
    @GetMapping("/votes/{candidateId}")
    public int getCandidateVotes(@PathVariable Long candidateId) {
        return candidateService.getCandidateVotes(candidateId);
    }
}
