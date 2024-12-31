package com.salim.stage.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class DomaineCompetence {
	@Id
	private String nomDomaine ; 
	@JsonIgnore
	@ManyToMany(mappedBy = "domaines")
    private List<Collaborateur> collaborateurs = new ArrayList<>();
	
    @OneToMany(mappedBy = "domaine") 
	private List<Competence> competences ;


	
}
