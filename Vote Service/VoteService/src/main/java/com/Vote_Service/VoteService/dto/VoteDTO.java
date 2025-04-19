package com.Vote_Service.VoteService.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoteDTO {

    @NotNull(message = "Voter ID cannot be null")
    private Long voterId;

    @NotNull(message = "Candidate ID cannot be null")
    private Long candidateId;

    @NotNull(message = "Election ID cannot be null")
    private Long electionId;
}
