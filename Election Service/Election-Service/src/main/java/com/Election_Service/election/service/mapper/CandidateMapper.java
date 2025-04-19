package com.Election_Service.election.service.mapper;

import org.mapstruct.Mapper;
import com.Election_Service.election.service.dto.CandidateDTO;
import com.Election_Service.election.service.model.Candidate;

@Mapper(componentModel = "spring") // THIS IS REQUIRED
public interface CandidateMapper {
    CandidateDTO toDTO(Candidate candidate);
    Candidate toEntity(CandidateDTO dto);
}
