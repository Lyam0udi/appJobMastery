package com.jobmastery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jobmastery.model.Company;


public interface ICompanyRepository extends JpaRepository<Company, Long> {

}
