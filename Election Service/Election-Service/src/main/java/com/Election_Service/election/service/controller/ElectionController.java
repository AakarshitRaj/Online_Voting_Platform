package com.Election_Service.election.service.controller;

import java.util.*;

import org.springframework.web.bind.annotation.*;
import com.Election_Service.election.service.dto.ElectionDTO;
import com.Election_Service.election.service.model.Election;
import com.Election_Service.election.service.service.ElectionService;

@RestController
@RequestMapping("/api/election")
public class ElectionController {

	private final ElectionService electionService;
	
	public ElectionController(ElectionService electionService) {
        this.electionService = electionService;
    }
	
	@PostMapping
	public Election createElection(@RequestBody ElectionDTO electionDTO) {
		return electionService.createElection(electionDTO);
	}
	
	@GetMapping
	public List<Election> getAllElections(){
		return electionService.getAllElections();
	}
	
	
}
