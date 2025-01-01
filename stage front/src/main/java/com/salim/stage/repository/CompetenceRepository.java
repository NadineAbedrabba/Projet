package com.salim.stage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.salim.stage.entities.Competence;

@RepositoryRestResource(path = "competence")

public interface CompetenceRepository extends JpaRepository<Competence , String > {
	 List<Competence> findByNomCompetenceContains(String nom); 
	 List<Competence> findByScoreCompetence ( Integer score) ;
	 List<Competence> findByNiveauCompetence ( String Niveau) ;
	 List<Competence> findByNiveauCompetenceContains ( String Niveau) ;
	 
	 @Query("select c from Competence c where c.domaine.nomDomaine like %?1%")
	    List<Competence> findByNomDomaine(String nom);



	 

}
