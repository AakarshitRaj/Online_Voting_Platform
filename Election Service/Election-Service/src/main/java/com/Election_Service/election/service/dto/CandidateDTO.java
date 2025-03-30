package com.Election_Service.election.service.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateDTO {
	 @NotBlank(message = "Candidate name is required")
	    private String name;
	    
	    @NotNull(message = "Election ID is required")
	    private Long electionId;

	    @NotBlank(message = "Party name is required")
	    private String party;
}
