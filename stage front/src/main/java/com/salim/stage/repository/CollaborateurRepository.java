package com.salim.stage.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.salim.stage.entities.Collaborateur;


@RepositoryRestResource(path = "collab")
public interface CollaborateurRepository extends JpaRepository<Collaborateur, Long> {
	
	
	List<Collaborateur> findByNomCollaborateur(String nom);
	 List<Collaborateur> findByNomCollaborateurContains(String nom); 

	 

}
 