package com.Election_Service.election.service.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="election")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Election {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	public Election(String name, Date startDate, Date endDate) {
		
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Temporal(TemporalType.DATE)
    @Column(nullable = false)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
    @Column(nullable = false)
	private Date endDate;
	
	
	private boolean isActive;


}
