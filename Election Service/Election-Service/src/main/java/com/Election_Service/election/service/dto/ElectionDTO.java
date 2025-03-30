package com.Election_Service.election.service.dto;

import java.util.Date;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElectionDTO {

	 @NotBlank(message = "Election name is required")
	    private String name;


		@NotNull(message = "Start date is required")
	    private Date startDate;

	    @NotNull(message = "End date is required")
	    private Date endDate;


	
}
