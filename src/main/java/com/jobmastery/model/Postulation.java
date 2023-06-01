package com.jobmastery.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Postulation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPostulation;

    private String postulationName;
    private String description; // description offer
    private LocalDate postulationDate;
    private String contactPerson;
    private String email;
    private String companyDescription;
    private String stage;
    private String interviewPreparation;
    private LocalDate interviewDate;
    
    @ManyToOne
    @JoinColumn(name = "job_offer_id")
    private JobOffer jobOffer;
    
    // Empty constructor
    public Postulation() {
    	
    }
    
    // Getters and setters

    public Long getIdPostulation() {
        return idPostulation;
    }

    public void setIdPostulation(Long idPostulation) {
        this.idPostulation = idPostulation;
    }

    public String getPostulationName() {
        return postulationName;
    }

    public void setPostulationName(String postulationName) {
        this.postulationName = postulationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPostulationDate() {
        return postulationDate;
    }

    public void setPostulationDate(LocalDate postulationDate) {
        this.postulationDate = postulationDate;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getInterviewPreparation() {
        return interviewPreparation;
    }

    public void setInterviewPreparation(String interviewPreparation) {
        this.interviewPreparation = interviewPreparation;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    public JobOffer getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(JobOffer jobOffer) {
        this.jobOffer = jobOffer;
    }
    
    // Constructor using fields

    public Postulation(String postulationName, String description, LocalDate postulationDate, String contactPerson,
            String email, String companyDescription, String stage, String interviewPreparation,
            LocalDate interviewDate) {
        this.postulationName = postulationName;
        this.description = description;
        this.postulationDate = postulationDate;
        this.contactPerson = contactPerson;
        this.email = email;
        this.companyDescription = companyDescription;
        this.stage = stage;
        this.interviewPreparation = interviewPreparation;
        this.interviewDate = interviewDate;
    }
}

