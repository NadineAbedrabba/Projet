package com.salim.stage.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString(exclude = "domaines") // Exclure le champ 'domaines' de la méthode toString()

public class Collaborateur {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCollaborateur ; 
	private String nomCollaborateur ; 
	private String prenomCollaborateur ; 
	private Date dateDeNaissance ; 
	private String emailCollaborateur ; 
	private Integer telCollaborateur ; 
	private String positionCollaborateur ; 
	
	@JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "collaborateur_domaines",
        joinColumns = @JoinColumn(name = "collaborateur_id"),
        inverseJoinColumns = @JoinColumn(name = "domaine_id")
    )
    private List<DomaineCompetence> domaines = new ArrayList<>();

	
	


	public Collaborateur(String nomCollaborateur, String prenomCollaborateur, Date dateDeNaissance,
			String emailCollaborateur, Integer telCollaborateur) {
		super();
		this.nomCollaborateur = nomCollaborateur;
		this.prenomCollaborateur = prenomCollaborateur;
		this.dateDeNaissance = dateDeNaissance;
		
		this.emailCollaborateur = emailCollaborateur;
		this.telCollaborateur = telCollaborateur;
	}
	 public Collaborateur() {
	        // Empty constructor
	    }

	

	public Collaborateur(Long idCollaborateur, String nomCollaborateur, String prenomCollaborateur,
			Date dateDeNaissance, String emailCollaborateur, Integer telCollaborateur) {
		super();
		this.idCollaborateur = idCollaborateur;
		this.nomCollaborateur = nomCollaborateur;
		this.prenomCollaborateur = prenomCollaborateur;
		this.dateDeNaissance = dateDeNaissance;
		this.emailCollaborateur = emailCollaborateur;
		this.telCollaborateur = telCollaborateur;
	}


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


	
	
	
	
	
}
