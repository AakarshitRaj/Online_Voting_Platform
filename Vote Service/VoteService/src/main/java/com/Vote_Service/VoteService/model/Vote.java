package com.Vote_Service.VoteService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.UniqueConstraint; // ✅ Correct
import jakarta.validation.constraints.NotNull;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "votes", uniqueConstraints = @UniqueConstraint(columnNames = "voterId"))
public class Vote {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	@NotNull
	    private Long id;

	    @Column(nullable = false)
	    private Long voterId; // Assuming voter ID is tracked

	
	    @Column(nullable = false)
	    private Long candidateId; // Store candidate ID instead of entity reference
	    
	    @Column(nullable = false)
	    private Long electionId;
}
