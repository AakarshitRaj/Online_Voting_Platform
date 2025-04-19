package com.Vote_Service.VoteService.client;

import com.Vote_Service.VoteService.dto.CandidateDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@FeignClient(name = "candidate-service", url = "${http://localhost:8080/api/elections}")
@Component
public class CandidateClient {

    private static final Logger logger = LoggerFactory.getLogger(CandidateClient.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${election.service.url}")
    private String electionServiceBaseUrl;

    public CandidateDTO getCandidateById(Long candidateId) {
        if (candidateId == null || candidateId <= 0) {
            logger.warn("Invalid candidate ID provided: {}", candidateId);
            return null;
        }

        try {
            String url = UriComponentsBuilder.fromHttpUrl(electionServiceBaseUrl)
                    .path("/api/candidate/{id}")
                    .buildAndExpand(candidateId)
                    .toUriString();

            return restTemplate.getForObject(url, CandidateDTO.class);

        } catch (HttpClientErrorException.NotFound e) {
            logger.warn("Candidate not found with ID: {}", candidateId);
            return null;
        } catch (HttpClientErrorException e) {
            logger.error("Client error while fetching candidate with ID {}: {}", candidateId, e.getMessage());
            return null;
        } catch (Exception e) {
            logger.error("Unexpected error while calling Election Service: {}", e.getMessage(), e);
            return null;
        }
    }
}
