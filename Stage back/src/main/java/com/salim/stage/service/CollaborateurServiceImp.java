package com.salim.stage.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salim.stage.dto.CollaborateurDTO;
import com.salim.stage.entities.Collaborateur;
import com.salim.stage.entities.DomaineCompetence;
import com.salim.stage.repository.CollaborateurRepository;
import com.salim.stage.repository.DomaineRepository;

import jakarta.transaction.Transactional;
@Service
public class CollaborateurServiceImp implements CollaborateurService{
	
	@Autowired
	CollaborateurRepository collaborateurRepository ;
	
	
	@Autowired
	DomaineRepository domaineRepository  ;
	

	
	@Autowired
	ModelMapper modelMapper;
	
	@Transactional
	public CollaborateurDTO saveCollaborateur(Collaborateur Collab) {
		
		return convertEntityToDto( collaborateurRepository.save(Collab));
	}

	@Override
	public Collaborateur updateCollaborateur(Collaborateur Collab) {
		return collaborateurRepository.save(Collab);
	}

	@Override
	public void deleteCollaborateur(Collaborateur Collab) {
		collaborateurRepository.delete(Collab);
	}

	@Override
	public void deleteCollaborateurById(Long id) {
		collaborateurRepository.deleteById(id);
		
	}

	@Override
	public CollaborateurDTO getCollaborateur(Long id) {
		return convertEntityToDto ( collaborateurRepository.findById(id).get());
	}

	@Override
	public List<CollaborateurDTO> getAllCollaborateurs() {
		return collaborateurRepository.findAll().stream()
				.map(this ::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<Collaborateur> findByNomCollaborateur(String nom) {
		
		return collaborateurRepository.findByNomCollaborateur(nom);
	}

	@Override
	public List<Collaborateur> findByNomCollaborateurContains(String nom) {
		return collaborateurRepository.findByNomCollaborateurContains(nom);
	}

	
	
	@Override
	public Collaborateur convertDtoToEntity(CollaborateurDTO collaborateurDTO) {
		Collaborateur collab = new Collaborateur();
		collab = modelMapper.map( collaborateurDTO ,  Collaborateur.class);
		return collab ; }

	@Transactional
	public CollaborateurDTO saveCollaborateur(CollaborateurDTO C) {
	    Collaborateur collaborateur = convertDtoToEntity(C);

	    List<DomaineCompetence> domainesExistants = domaineRepository.findAll();
	    
	    collaborateur.setDomaines(domainesExistants);

	    Collaborateur savedCollaborateur = collaborateurRepository.save(collaborateur);

	    return convertEntityToDto(savedCollaborateur);
	}

	@Override
	public CollaborateurDTO updateCollaborateur(CollaborateurDTO C) {
		 return convertEntityToDto( collaborateurRepository.save(convertDtoToEntity(C)));
	}

	@Override
	public CollaborateurDTO convertEntityToDto(Collaborateur collab) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

		CollaborateurDTO collabDTO = modelMapper.map(collab, CollaborateurDTO.class);
		 return collabDTO; 		
	}

	
	

}
