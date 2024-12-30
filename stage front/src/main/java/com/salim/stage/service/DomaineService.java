package com.salim.stage.service;

import java.util.List;

import com.salim.stage.dto.DomaineDTO;
import com.salim.stage.entities.DomaineCompetence;

public interface DomaineService {

	DomaineDTO saveDomaineCompetence(DomaineCompetence d);
	DomaineCompetence updateDomaineCompetence(DomaineCompetence Collab);
	void deleteDomaineCompetence(DomaineCompetence Collab);
	void deleteDomaineCompetenceById (String Nom ) ;
	 DomaineDTO getDomaineCompetence ( String Nom );
	List<DomaineDTO> getAllDomaineCompetence();
	 List<DomaineCompetence> findByNomDomaineContains(String nom); 
	 
	 DomaineDTO convertEntityToDto (DomaineCompetence collab);
	 DomaineCompetence convertDtoToEntity(DomaineDTO collabDTO );

	 DomaineDTO saveDomaineCompetence(DomaineDTO C);	
	 DomaineDTO updateDomaineCompetence(DomaineDTO C);
}
