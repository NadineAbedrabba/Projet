
package com.salim.stage.dto;

import java.util.Date;
import java.util.List;

import com.salim.stage.entities.DomaineCompetence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollaborateurDTO {
	private Long idCollaborateur ; 
	private String nomCollaborateur ; 
	private String prenomCollaborateur ; 
	private Date dateDeNaissance ; 
	private String emailCollaborateur ; 
	private Integer telCollaborateur ; 
	private String positionCollaborateur ; 
	private List<DomaineCompetence> domaines ;


}
