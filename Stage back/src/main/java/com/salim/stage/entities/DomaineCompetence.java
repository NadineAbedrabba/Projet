package com.salim.stage.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DomaineCompetence {
	@Id
	private String nomDomaine ; 
	
	@JsonIgnore
	@ManyToMany(mappedBy = "domaines")
    private List<Collaborateur> collaborateurs = new ArrayList<>();
	
    @OneToMany(mappedBy = "domaine") 
	private List<Competence> competences ;
    
    
    
    

	public String getNomDomaine() {
		return nomDomaine;
	}

	public void setNomDomaine(String nomDomaine) {
		this.nomDomaine = nomDomaine;
	}

	public List<Collaborateur> getCollaborateurs() {
		return collaborateurs;
	}

	public void setCollaborateurs(List<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public DomaineCompetence(String nomDomaine, List<Collaborateur> collaborateurs, List<Competence> competences) {
		super();
		this.nomDomaine = nomDomaine;
		this.collaborateurs = collaborateurs;
		this.competences = competences;
	}
    
    
    public DomaineCompetence() {
    	
    }
   

	
}


