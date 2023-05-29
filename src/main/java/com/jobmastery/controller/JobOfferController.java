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

import com.jobmastery.model.JobOffer;
import com.jobmastery.service.JobOfferService;

@Controller
@RequestMapping("/joboffer")
public class JobOfferController {

    @Autowired
    private JobOfferService jobOfferService;

    @GetMapping("/create")
    public String displayJobOfferForm(Model model) {
        JobOffer jobOffer = new JobOffer();
        model.addAttribute("jobOffer", jobOffer);
        return "joboffer/new-joboffer";
    }

    @PostMapping("/create")
    public String createJobOffer(@ModelAttribute("jobOffer") JobOffer jobOffer) {
        jobOfferService.createJobOffer(jobOffer);
        return "redirect:/joboffer/create";
    }

    @GetMapping
    public String displayJobOfferList(Model model) {
        List<JobOffer> jobOffers = jobOfferService.getAllJobOffers();
        model.addAttribute("jobOffers", jobOffers);
        return "joboffer/joboffer-list";
    }

    @GetMapping("/delete/{id}")
    public String deleteJobOffer(@PathVariable("id") Long id) {
        jobOfferService.deleteJobOfferById(id);
        return "redirect:/joboffer";
    }

    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") Long id, Model model) {
        JobOffer jobOffer = jobOfferService.getJobOfferById(id);
        model.addAttribute("jobOffer", jobOffer);
        return "joboffer/update-joboffer";
    }

    @PostMapping("/update/{id}")
    public String handleUpdateForm(@PathVariable("id") Long id, @ModelAttribute("jobOffer") JobOffer updatedJobOffer) {
        JobOffer existingJobOffer = jobOfferService.getJobOfferById(id);
        BeanUtils.copyProperties(updatedJobOffer, existingJobOffer, "id"); // Copy updated fields to existing job offer

        jobOfferService.updateJobOffer(existingJobOffer);
        return "redirect:/joboffer";
    }

    @PostMapping("/update")
    public String handleUpdateForm(@ModelAttribute("jobOffer") JobOffer jobOffer) {
        jobOfferService.updateJobOffer(jobOffer);
        return "redirect:/joboffer";
    }
}
