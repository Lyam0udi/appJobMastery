package com.jobmastery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobmastery.model.Postulation;
import com.jobmastery.repository.IPostulationRepository;

@Service
public class PostulationService {
	
	private final IPostulationRepository postulationRepository;

    @Autowired
    public PostulationService(IPostulationRepository postulationRepository) {
        this.postulationRepository = postulationRepository;
    }


    public void createPostulation(Postulation postulation) {
        postulationRepository.save(postulation);
    }
    
    public List<Postulation> getAllPostulations() {
        return postulationRepository.findAll();
    }
    
    public void deletePostulationById(Long id) {
        postulationRepository.deleteById(id);
    }
    
    public Postulation getPostulationById(Long id) {
        return postulationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid postulation id: " + id));
    }
    
    public void updatePostulation(Postulation postulation) {
        // Retrieve the existing postulation from the database
        Postulation existingPostulation = postulationRepository.findById(postulation.getIdPostulation())
                .orElseThrow(() -> new RuntimeException("Postulation not found"));

        // Update the fields of the existing postulation with the new values
        existingPostulation.setPostulationName(postulation.getPostulationName());
        existingPostulation.setDescription(postulation.getDescription());
        existingPostulation.setPostulationDate(postulation.getPostulationDate());
        existingPostulation.setContactPerson(postulation.getContactPerson());
        existingPostulation.setEmail(postulation.getEmail());
        existingPostulation.setCompanyDescription(postulation.getCompanyDescription());
        existingPostulation.setStage(postulation.getStage());
        existingPostulation.setInterviewPreparation(postulation.getInterviewPreparation());
        existingPostulation.setInterviewDate(postulation.getInterviewDate());
        // ... update other fields ...

        // Save the updated postulation in the database
        postulationRepository.save(existingPostulation);
    }

}
