package com.salim.stage.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.salim.stage.entities.DomaineCompetence;

@RepositoryRestResource(path = "domaine")

public interface DomaineRepository extends JpaRepository<DomaineCompetence, String> {
	List<DomaineCompetence> findByNomDomaine(String nom);
	 List<DomaineCompetence> findByNomDomaineContains(String nom); 

	
		    @Query("SELECT d FROM DomaineCompetence d LEFT JOIN FETCH d.collaborateurs WHERE d.nomDomaine = :nomDomaine")
		    Optional<DomaineCompetence> findByNomDomaineWithCollaborateurs(@Param("nomDomaine") String nomDomaine);
		}

