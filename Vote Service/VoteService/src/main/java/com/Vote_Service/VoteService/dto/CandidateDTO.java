package com.Vote_Service.VoteService.dto;

public class CandidateDTO {
    private Long id;
    private String name;
    private String party;
    private Long electionId; // ✅ Add this field

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }
    public void setParty(String party) {
        this.party = party;
    }

    public Long getElectionId() {
        return electionId;
    }
    public void setElectionId(Long electionId) {
        this.electionId = electionId;
    }
}
