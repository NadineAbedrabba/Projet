package com.salim.stage.dto;


import com.salim.stage.entities.DomaineCompetence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CompetenceDTO {
	private  String nomCompetence ; 
	private  Integer scoreCompetence ;
	private String niveauCompetence ;
	private DomaineCompetence domaine ;
    
}
