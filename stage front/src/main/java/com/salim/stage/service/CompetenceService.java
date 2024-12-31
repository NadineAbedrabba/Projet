package com.salim.stage.service;

import java.util.List;

import com.salim.stage.dto.CompetenceDTO;
import com.salim.stage.entities.Competence;

public interface CompetenceService {
	CompetenceDTO saveCompetence(Competence C);
	CompetenceDTO updateCompetence(Competence comp);
	void deleteCompetence(Competence comp);
	void deleteCompetenceById (String Nom ) ;
	 CompetenceDTO	 getCompetence ( String Nom );
	List<CompetenceDTO> getAllCompetences();
	 List<Competence> findByScoreCompetence(Integer score); 
	 List<Competence> findByNiveauCompetence(String niveau); 
	 List<Competence> findByNiveauCompetenceContains(String niveau); 
	 
	 
	 List<Competence> findByNomDomaine (String domaine); 
	 

	 
	 
	 CompetenceDTO convertEntityToDto (Competence comp);
	 Competence convertDtoToEntity(CompetenceDTO comp );
	 
	 CompetenceDTO saveCompetence(CompetenceDTO C);	
	 CompetenceDTO updateCompetence(CompetenceDTO C);
	 
}
