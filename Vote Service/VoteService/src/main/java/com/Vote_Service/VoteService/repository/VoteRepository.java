package com.Vote_Service.VoteService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Vote_Service.VoteService.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
