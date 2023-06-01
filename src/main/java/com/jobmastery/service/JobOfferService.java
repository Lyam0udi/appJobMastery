package com.jobmastery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobmastery.model.JobOffer;
import com.jobmastery.repository.IJobOfferRepository;

@Service
public class JobOfferService {

    private final IJobOfferRepository jobOfferRepository;

    @Autowired
    public JobOfferService(IJobOfferRepository jobOfferRepository) {
        this.jobOfferRepository = jobOfferRepository;
    }

    public void createJobOffer(JobOffer jobOffer) {
        jobOfferRepository.save(jobOffer);
    }

    public List<JobOffer> getAllJobOffers() {
        return jobOfferRepository.findAll();
    }

    public void deleteJobOfferById(Long id) {
        jobOfferRepository.deleteById(id);
    }

    public JobOffer getJobOfferById(Long id) {
        return jobOfferRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid job offer id: " + id));
    }

    public void updateJobOffer(JobOffer jobOffer) {
        // Retrieve the existing job offer from the database
        JobOffer existingJobOffer = jobOfferRepository.findById(jobOffer.getIdJobOffer())
                .orElseThrow(() -> new RuntimeException("Job offer not found"));

        // Update the fields of the existing job offer with the new values
        existingJobOffer.setNameJobOffer(jobOffer.getNameJobOffer());
        existingJobOffer.setDescriptionJobOffer(jobOffer.getDescriptionJobOffer());
        // ... update other fields ...

        // Save the updated job offer in the database
        jobOfferRepository.save(existingJobOffer);
    }
}


