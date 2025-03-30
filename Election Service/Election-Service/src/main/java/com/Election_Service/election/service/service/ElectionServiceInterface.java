package com.Election_Service.election.service.service;

import java.util.List;

import com.Election_Service.election.service.dto.ElectionDTO;
import com.Election_Service.election.service.model.Election;

public interface ElectionServiceInterface {

    Election createElection(ElectionDTO electionDTO);
    List<Election> getAllElections();
    Election getElectionById(Long electionId);
}
