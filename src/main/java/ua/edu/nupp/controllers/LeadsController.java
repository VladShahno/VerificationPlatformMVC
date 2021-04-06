package ua.edu.nupp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.edu.nupp.dao.LeadDAO;

import org.springframework.ui.Model;

@Controller
@RequestMapping()
public class LeadsController {

    
    private LeadDAO leadDAO;

    @Autowired
    public LeadsController(LeadDAO leadDAO) {
        this.leadDAO = leadDAO; 
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("leads", leadDAO.index());
        return "leads/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("lead", leadDAO.show(id));
        return "leads/show";
    } 
}