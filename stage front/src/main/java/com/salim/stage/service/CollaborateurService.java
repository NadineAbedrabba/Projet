package com.salim.stage.service;

import java.util.List;

import com.salim.stage.dto.CollaborateurDTO;
import com.salim.stage.entities.Collaborateur;
import com.salim.stage.entities.DomaineCompetence;



public interface CollaborateurService {

	CollaborateurDTO saveCollaborateur(Collaborateur Collab);
	Collaborateur updateCollaborateur(Collaborateur Collab);
	void deleteCollaborateur(Collaborateur Collab);
	 void deleteCollaborateurById(Long id);
	 CollaborateurDTO getCollaborateur(Long id);
	List<CollaborateurDTO> getAllCollaborateurs();
	List<Collaborateur> findByNomCollaborateur(String nom);
	 List<Collaborateur> findByNomCollaborateurContains(String nom); 
	 
	 CollaborateurDTO convertEntityToDto (Collaborateur collab);
	 Collaborateur convertDtoToEntity(CollaborateurDTO collabDTO );

	 CollaborateurDTO saveCollaborateur(CollaborateurDTO C);
	 CollaborateurDTO updateCollaborateur(CollaborateurDTO C);
	
}
