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
}
