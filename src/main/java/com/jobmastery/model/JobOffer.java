package com.jobmastery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class JobOffer {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idJobOffer;
	private String nameJobOffer;
	private String descriptionJobOffer;
	
	// empty contructor 
	public JobOffer() {
		
	}
	
	// Getters and Setters

	public long getIdJobOffer() {
		return idJobOffer;
	}

	public void setIdJobOffer(long idJobOffer) {
		this.idJobOffer = idJobOffer;
	}

	public String getNameJobOffer() {
		return nameJobOffer;
	}

	public void setNameJobOffer(String nameJobOffer) {
		this.nameJobOffer = nameJobOffer;
	}

	public String getDescriptionJobOffer() {
		return descriptionJobOffer;
	}

	public void setDescriptionJobOffer(String descriptionJobOffer) {
		this.descriptionJobOffer = descriptionJobOffer;
	}
	
	// Constructor using fields 
	
	public JobOffer(String nameJobOffer, String descriptionJobOffer) {
		super();
		this.nameJobOffer = nameJobOffer;
		this.descriptionJobOffer = descriptionJobOffer;
	}
}
