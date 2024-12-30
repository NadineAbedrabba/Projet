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
    
	
	
	
	
	public String getNomCompetence() {
		return nomCompetence;
	}
	public void setNomCompetence(String nomCompetence) {
		this.nomCompetence = nomCompetence;
	}
	public Integer getScoreCompetence() {
		return scoreCompetence;
	}
	public void setScoreCompetence(Integer scoreCompetence) {
		this.scoreCompetence = scoreCompetence;
	}
	public String getNiveauCompetence() {
		return niveauCompetence;
	}
	public void setNiveauCompetence(String niveauCompetence) {
		this.niveauCompetence = niveauCompetence;
	}
	public DomaineCompetence getDomaine() {
		return domaine;
	}
	public void setDomaine(DomaineCompetence domaine) {
		this.domaine = domaine;
	}
	
}
