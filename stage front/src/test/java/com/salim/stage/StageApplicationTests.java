package com.salim.stage;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salim.stage.entities.Collaborateur;
import com.salim.stage.entities.DomaineCompetence;
import com.salim.stage.repository.CollaborateurRepository;
import com.salim.stage.repository.DomaineRepository;
import com.salim.stage.service.DomaineService;

import jakarta.transaction.Transactional;

@SpringBootTest
class StageApplicationTests {

	@Autowired
	private CollaborateurRepository collaborateurRepository;
	@Autowired
    private DomaineService domaineService;

	
	@Autowired
	private DomaineRepository domaineRepository ;
	@Test
	public void testCreateCollaborateur() {
	Collaborateur collab = new Collaborateur("Salim","Brahem",new Date(),"Salimbrahem@gmail.com",512341246);
	collaborateurRepository.save(collab);
	}
	@Transactional
	@Test 
	public void testFindByNomCollaborateur()
	{
	List<Collaborateur> collabs = collaborateurRepository.findByNomCollaborateur("salim");
	for (Collaborateur c : collabs )
	{
	    System.out.println(c);
	}
	
	}
	@Transactional
	@Test
    public void testFindCollaborateurs() {
        DomaineCompetence domaine = domaineRepository.findById("BD").orElse(null);

        if (domaine != null) {
            List<Collaborateur> collabs = domaine.getCollaborateurs();
            for (Collaborateur c : collabs) {
                System.out.println(c);
            }
        } else {
            System.out.println("Domaine with ID 'BD' not found.");
        }
    }
	
	
	 @Test
	    public void testDeleteDomaineCompetence() {
	        DomaineCompetence domaine = domaineRepository.findById("SYST").orElse(null);
	        
	        domaineService.deleteDomaineCompetence(domaine);

	    }
	}


	

