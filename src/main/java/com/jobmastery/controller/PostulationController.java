package com.jobmastery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        return "new-postulation";
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
        return "postulation-list";
    }
}
