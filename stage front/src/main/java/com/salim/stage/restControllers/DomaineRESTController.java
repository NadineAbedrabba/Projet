package com.salim.stage.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salim.stage.dto.DomaineDTO;
import com.salim.stage.service.DomaineService;

@RestController
@RequestMapping("/api/domaine")
@CrossOrigin
public class DomaineRESTController {
  @Autowired
  DomaineService domaineService ;
  
  @RequestMapping(method = RequestMethod.GET)
	public List<DomaineDTO> getAllDomaineCompetence() {
	return domaineService.getAllDomaineCompetence();
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public DomaineDTO getDomaineCompetenceById(@PathVariable("id") String nom) {
	return domaineService.getDomaineCompetence(nom);
	 }
	
	
	@RequestMapping(method = RequestMethod.POST)
	public DomaineDTO createDomaineCompetence(@RequestBody DomaineDTO DTO) {
	return domaineService.saveDomaineCompetence(DTO);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public DomaineDTO updateDomaineCompetence(@RequestBody DomaineDTO collabDTO) {
	return domaineService.updateDomaineCompetence(collabDTO);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteDomaineCompetence(@PathVariable("id") String nom)
	{
		domaineService.deleteDomaineCompetenceById(nom);
	}
	
  
  
  
  
  
  
}
