package com.jobmastery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobmastery.model.Company;
import com.jobmastery.repository.ICompanyRepository;

@Service
public class CompanyService {
	
	private final ICompanyRepository companyRepository;

    @Autowired
    public CompanyService(ICompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public void createCompany(Company company) {
        companyRepository.save(company);
    }
    
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
    
    public void deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
    }
    
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid company id: " + id));
    }
    
    public void updateCompany(Company company) {
        // Retrieve the existing company from the database
        Company existingCompany = companyRepository.findById(company.getIdCompany())
                .orElseThrow(() -> new RuntimeException("Company not found"));

        // Update the fields of the existing company with the new values
        existingCompany.setNameCompany(company.getNameCompany());
        existingCompany.setAdresseCompany(company.getAdresseCompany());
        existingCompany.setCityCompany(company.getCityCompany());
        existingCompany.setPhoneCompany(company.getPhoneCompany());
        existingCompany.setWebSiteCompany(company.getWebSiteCompany());
        existingCompany.setPublicEmail(company.getPublicEmail());
        existingCompany.setImageLogo(company.getImageLogo());
        // ... update other fields ...

        // Save the updated company in the database
        companyRepository.save(existingCompany);
    }
}
