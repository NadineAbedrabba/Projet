package com.salim.stage.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salim.stage.dto.CollaborateurDTO;
import com.salim.stage.dto.DomaineDTO;
import com.salim.stage.entities.Collaborateur;
import com.salim.stage.entities.DomaineCompetence;
import com.salim.stage.repository.DomaineRepository;
import com.salim.stage.service.CollaborateurService;
import com.salim.stage.service.DomaineService;

@RestController
@RequestMapping("/api/collaborateur")
@CrossOrigin
public class CollaborateurRESTController {
	@Autowired
	DomaineRepository domaineRepository ;
	@Autowired
	CollaborateurService collaborateurService ; 
	
	
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<CollaborateurDTO> getAllCollaborateurs() {
	return collaborateurService.getAllCollaborateurs();
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public CollaborateurDTO getCollaborateurById(@PathVariable("id") Long id) {
	return collaborateurService.getCollaborateur(id);
	 }
	
	
	@RequestMapping(method = RequestMethod.POST)
	public CollaborateurDTO createCollaborateur(@RequestBody CollaborateurDTO DTO) {
	return collaborateurService.saveCollaborateur(DTO);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public CollaborateurDTO updateCollaborateur(@RequestBody CollaborateurDTO collabDTO) {
	return collaborateurService.updateCollaborateur(collabDTO);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteCollaborateur(@PathVariable("id") Long id)
	{
		collaborateurService.deleteCollaborateurById(id);
	}
	
	
	

	
}

