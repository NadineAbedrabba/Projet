package com.salim.stage.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Competence {
	@Id
	private  String nomCompetence ; 
	public String getNomCompetence() {
		return nomCompetence;
	}

	public void setNomCompetence(String nomCompetence) {
		this.nomCompetence = nomCompetence;
	}

	public DomaineCompetence getDomaine() {
		return domaine;
	}

	public void setDomaine(DomaineCompetence domaine) {
		this.domaine = domaine;
	}

	private  Integer scoreCompetence ;
	private String niveauCompetence ;
	
	@JsonIgnore
	@ManyToOne
	private DomaineCompetence domaine ;
	
	
	

	public String getNiveauCompetence() {
		return niveauCompetence;
	}

	public void setNiveauCompetence(String niveauCompetence) {
		this.niveauCompetence = niveauCompetence;
	}

	public Integer getScoreCompetence() {
		return scoreCompetence;
	}

	public void setScoreCompetence(Integer scoreCompetence) {
		this.scoreCompetence = scoreCompetence;
	}
    
}
