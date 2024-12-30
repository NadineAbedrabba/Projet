
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
	public Long getIdCollaborateur() {
		return idCollaborateur;
	}
	public void setIdCollaborateur(Long idCollaborateur) {
		this.idCollaborateur = idCollaborateur;
	}
	public String getNomCollaborateur() {
		return nomCollaborateur;
	}
	public void setNomCollaborateur(String nomCollaborateur) {
		this.nomCollaborateur = nomCollaborateur;
	}
	public String getPrenomCollaborateur() {
		return prenomCollaborateur;
	}
	public void setPrenomCollaborateur(String prenomCollaborateur) {
		this.prenomCollaborateur = prenomCollaborateur;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getEmailCollaborateur() {
		return emailCollaborateur;
	}
	public void setEmailCollaborateur(String emailCollaborateur) {
		this.emailCollaborateur = emailCollaborateur;
	}
	public Integer getTelCollaborateur() {
		return telCollaborateur;
	}
	public void setTelCollaborateur(Integer telCollaborateur) {
		this.telCollaborateur = telCollaborateur;
	}
	public String getPositionCollaborateur() {
		return positionCollaborateur;
	}
	public void setPositionCollaborateur(String positionCollaborateur) {
		this.positionCollaborateur = positionCollaborateur;
	}
	public List<DomaineCompetence> getDomaines() {
		return domaines;
	}
	public void setDomaines(List<DomaineCompetence> domaines) {
		this.domaines = domaines;
	}
	private String nomCollaborateur ; 
	private String prenomCollaborateur ; 
	private Date dateDeNaissance ; 
	private String emailCollaborateur ; 
	private Integer telCollaborateur ; 
	private String positionCollaborateur ; 
	private List<DomaineCompetence> domaines ;


}
