package com.jobmastery.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jobmastery.model.Company;
import com.jobmastery.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/create")
    public String displayCompanyForm(Model model) {
        Company company = new Company();
        model.addAttribute("company", company);
        return "company/new-company";
    }

    @PostMapping("/create")
    public String createCompany(@ModelAttribute("company") Company company) {
        companyService.createCompany(company);
        return "redirect:/company/create";
    }
    
    @GetMapping
    public String displayCompanyList(Model model) {
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        return "company/company-list";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteCompany(@PathVariable("id") Long id) {
        companyService.deleteCompanyById(id);
        return "redirect:/company";
    }
    
    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") Long id, Model model) {
        Company company = companyService.getCompanyById(id);
        model.addAttribute("company", company);
        return "company/update-company";
    }
    
    @PostMapping("/update/{id}")
    public String handleUpdateForm(@PathVariable("id") Long id, @ModelAttribute("company") Company updatedCompany) {
        Company existingCompany = companyService.getCompanyById(id);
        BeanUtils.copyProperties(updatedCompany, existingCompany, "id"); // Copy updated fields to existing company

        companyService.updateCompany(existingCompany);
        return "redirect:/company";
    }
    
    @PostMapping("/update")
    public String handleUpdateForm(@ModelAttribute("company") Company company) {
        companyService.updateCompany(company);
        return "redirect:/company";
    }
}

