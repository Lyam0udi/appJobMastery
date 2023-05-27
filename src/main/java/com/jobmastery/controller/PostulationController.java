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

import com.jobmastery.model.Postulation;
import com.jobmastery.service.PostulationService;

@Controller
@RequestMapping("/postulation")
public class PostulationController {

    @Autowired
    private PostulationService postulationService;

    @GetMapping("/create")
    public String displayPostulationForm(Model model) {
        Postulation postulation = new Postulation();
        model.addAttribute("postulation", postulation);
        return "postulation/new-postulation";
    }

    @PostMapping("/create")
    public String createPostulation(@ModelAttribute("postulation") Postulation postulation) {
        postulationService.createPostulation(postulation);
        return "redirect:/postulation/create";
    }
    
    @GetMapping
    public String displayPostulationList(Model model) {
        List<Postulation> postulations = postulationService.getAllPostulations();
        model.addAttribute("postulations", postulations);
        return "postulation/postulation-list";
    }
    
    @GetMapping("/delete/{id}")
    public String deletePostulation(@PathVariable("id") Long id) {
        postulationService.deletePostulationById(id);
        return "redirect:/postulation";
    }
    
    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") Long id, Model model) {
        Postulation postulation = postulationService.getPostulationById(id);
        model.addAttribute("postulation", postulation);
        return "postulation/update-postulation";

    }
    
    @PostMapping("/update/{id}")
    public String handleUpdateForm(@PathVariable("id") Long id, @ModelAttribute("postulation") Postulation updatedPostulation) {
        Postulation existingPostulation = postulationService.getPostulationById(id);
        BeanUtils.copyProperties(updatedPostulation, existingPostulation, "id"); // Copy updated fields to existing postulation

        postulationService.updatePostulation(existingPostulation);
        return "redirect:/postulation";
    }
    
    @PostMapping("/update")
    public String handleUpdateForm(@ModelAttribute("postulation") Postulation postulation) {
        postulationService.updatePostulation(postulation);
        return "redirect:/postulation";
    }

}
