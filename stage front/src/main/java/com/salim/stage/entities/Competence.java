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
	private  Integer scoreCompetence ;
	private String niveauCompetence ;
	
	@JsonIgnore
	@ManyToOne
	private DomaineCompetence domaine ;
    
}
