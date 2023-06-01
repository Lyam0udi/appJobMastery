package com.jobmastery.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class JobOffer {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idJobOffer;
    
    private String nameJobOffer;
    private String descriptionJobOffer;
    
    @OneToMany(mappedBy = "jobOffer")
    private List<Postulation> postulations;
	
    // Empty constructor 
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

    public List<Postulation> getPostulations() {
        return postulations;
    }

    public void setPostulations(List<Postulation> postulations) {
        this.postulations = postulations;
    }
    
    // Constructor using fields 

    public JobOffer(String nameJobOffer, String descriptionJobOffer) {
        this.nameJobOffer = nameJobOffer;
        this.descriptionJobOffer = descriptionJobOffer;
    }
}
