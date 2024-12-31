package com.salim.stage.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salim.stage.dto.CompetenceDTO;
import com.salim.stage.entities.Competence;
import com.salim.stage.repository.CompetenceRepository;

@Service
public class CompetenceServiceImp implements CompetenceService {
	
	
	@Autowired
	CompetenceRepository competenceRepository ;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public CompetenceDTO saveCompetence(Competence C) {
		return convertEntityToDto( competenceRepository.save(C));
	}

	@Override
	public CompetenceDTO updateCompetence(Competence comp) {
		return convertEntityToDto( competenceRepository.save(comp)); }

	@Override
	public void deleteCompetence(Competence comp) {
		competenceRepository.delete(comp);
		
	}

	@Override
	public void deleteCompetenceById(String Nom) {
		competenceRepository.deleteById(Nom);
		
	}

	@Override
	public CompetenceDTO getCompetence(String Nom) {
		return convertEntityToDto ( competenceRepository.findById(Nom).get());
	}

	@Override
	public List<CompetenceDTO> getAllCompetences() {
		return competenceRepository.findAll().stream()
				.map(this ::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<Competence> findByScoreCompetence(Integer score) {
		return competenceRepository.findByScoreCompetence(score);
	}

	@Override
	public List<Competence> findByNiveauCompetence(String niveau) {
		return competenceRepository.findByNiveauCompetence(niveau );
	}

	@Override
	public List<Competence> findByNiveauCompetenceContains(String niveau) {
		return competenceRepository.findByNiveauCompetenceContains(niveau);
	}

	@Override
	public List<Competence> findByNomDomaine(String domaine) {
		return competenceRepository.findByNomDomaine(domaine);
	}

	

	@Override
	public CompetenceDTO convertEntityToDto(Competence comp) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

		CompetenceDTO compDTO = modelMapper.map(comp, CompetenceDTO.class);
		 return compDTO;
	}

	@Override
	public Competence convertDtoToEntity(CompetenceDTO compDTO) {
		Competence comp = new Competence();
		comp = modelMapper.map( compDTO ,  Competence.class);
		return comp ; 
	}

	@Override
	public CompetenceDTO saveCompetence(CompetenceDTO C) {
		return convertEntityToDto( competenceRepository.save(convertDtoToEntity(C)));
	}

	@Override
	public CompetenceDTO updateCompetence(CompetenceDTO C) {
		 return convertEntityToDto( competenceRepository.save(convertDtoToEntity(C)));
	}

	
	
	

}
