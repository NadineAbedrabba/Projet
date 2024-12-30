package com.salim.stage.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salim.stage.dto.CompetenceDTO;
import com.salim.stage.service.CompetenceService;

@RestController
@RequestMapping("/api/competence")
@CrossOrigin
public class CompetenceRESTController {

	@Autowired
	CompetenceService competenceService ; 
	
	@RequestMapping(method = RequestMethod.GET)
	public List<CompetenceDTO> getAllCompetences() {
	return competenceService.getAllCompetences();
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public CompetenceDTO getCompetenceById(@PathVariable("id") String nom) {
	return competenceService.getCompetence(nom);
	 }
	
	
	@RequestMapping(method = RequestMethod.POST)
	public CompetenceDTO createCollaborateur(@RequestBody CompetenceDTO DTO) {
	return competenceService.saveCompetence(DTO);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public CompetenceDTO updateCompetence(@RequestBody CompetenceDTO compDTO) {
	return competenceService.updateCompetence(compDTO);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteCompetence(@PathVariable("id") String nom )
	{
		competenceService.deleteCompetenceById(nom);
	}
}
