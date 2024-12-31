package com.salim.stage.dto;

import java.util.List;

import com.salim.stage.entities.Competence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DomaineDTO {
	private String nomDomaine ; 
	private List<Competence> competences ;

}
