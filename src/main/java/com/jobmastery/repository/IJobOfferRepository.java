package com.jobmastery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobmastery.model.JobOffer;

public interface IJobOfferRepository extends JpaRepository<JobOffer, Long>{

}
