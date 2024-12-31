package com.salim.stage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salim.stage.dto.DomaineDTO;
import com.salim.stage.entities.Collaborateur;
import com.salim.stage.entities.DomaineCompetence;
import com.salim.stage.repository.CollaborateurRepository;
import com.salim.stage.repository.DomaineRepository;

import jakarta.transaction.Transactional;
@Service
public  class  DomaineServiceImp implements DomaineService{
	@Autowired
	DomaineRepository domaineRepository ; 
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	CollaborateurRepository collaborateurRepository ;
	
	

	@Override
	public DomaineDTO saveDomaineCompetence(DomaineCompetence d) {
		return convertEntityToDto( domaineRepository.save(d) );}
	

	@Override
	public DomaineCompetence updateDomaineCompetence(DomaineCompetence domaine) {
		return domaineRepository.save(domaine);

	}
	

	 @Override
	    @Transactional
	    public void deleteDomaineCompetence(DomaineCompetence domaine) {
	        Optional<DomaineCompetence> domaineWithCollaborateurs = domaineRepository.findByNomDomaineWithCollaborateurs(domaine.getNomDomaine());

	        domaineWithCollaborateurs.ifPresent(domaineFetched -> {
	            for (Collaborateur c : domaineFetched.getCollaborateurs()) {
	                c.getDomaines().remove(domaineFetched);
	            }
	            domaineRepository.delete(domaineFetched);
	        });
	    }

	@Override
	public List<DomaineDTO> getAllDomaineCompetence() {
		return domaineRepository.findAll().stream()
				.map(this ::convertEntityToDto)
				.collect(Collectors.toList());
	}

	

	@Override
	public List<DomaineCompetence> findByNomDomaineContains(String nom) {
		return domaineRepository.findByNomDomaineContains(nom);
	}

	@Override
	public DomaineDTO convertEntityToDto(DomaineCompetence domaine) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

		DomaineDTO domaineDTO = modelMapper.map(domaine, DomaineDTO.class);
		 return domaineDTO; 	
	}
	
	 
	 
	@Override
	public DomaineCompetence convertDtoToEntity(DomaineDTO domaineDTO) {
		DomaineCompetence domaine = new DomaineCompetence();
		domaine = modelMapper.map( domaineDTO ,  DomaineCompetence.class);
		return domaine ; 
	}

	@Transactional
	public DomaineDTO saveDomaineCompetence(DomaineDTO domaineDTO) {
		DomaineCompetence domaine = convertDtoToEntity(domaineDTO);
		DomaineCompetence savedDomaine = domaineRepository.save(domaine);
        
		updateCollaboratorsWithNewDomain(savedDomaine);
        
        return convertEntityToDto(savedDomaine);
	}

	public void updateCollaboratorsWithNewDomain(DomaineCompetence newDomain) {
	    List<Collaborateur> collaborators = collaborateurRepository.findAll();

	    for (Collaborateur collaborator : collaborators) {
	        collaborator.getDomaines().add(newDomain);
	    }

	    collaborateurRepository.saveAll(collaborators);
	}


	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public DomaineDTO updateDomaineCompetence(DomaineDTO domaine) {
		 return convertEntityToDto( domaineRepository.save(convertDtoToEntity(domaine)));
	}


	public DomaineDTO getDomaineCompetence(String nom) {
		return convertEntityToDto ( domaineRepository.findById(nom).get());		

}


	@Override
	public void deleteDomaineCompetenceById(String nom) {
		this.deleteDomaineCompetence(domaineRepository.findById(nom).get());}

		
	}
