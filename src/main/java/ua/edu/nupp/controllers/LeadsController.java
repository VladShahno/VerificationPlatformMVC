package ua.edu.nupp.controllers;

import ua.edu.nupp.models.Company;
import ua.edu.nupp.models.Lead;
import ua.edu.nupp.dao.LeadDAO;
import ua.edu.nupp.dao.CompanyDAO;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/leads")
public class LeadsController {

    private final LeadDAO leadDAO;
    
    
    private final CompanyDAO companyDAO;

    @Autowired
    public LeadsController(LeadDAO leadDAO, CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
        this.leadDAO = leadDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("leads", leadDAO.index());
        model.addAttribute("companies", companyDAO.index());     
        return "leads/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("lead", leadDAO.show(id));
        model.addAttribute("company", companyDAO.show(id));
        return "leads/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("lead") Lead lead) {
        return "leads/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("lead") Lead lead) {
        leadDAO.save(lead);
        return "redirect:/leads";
    }
    
    @PostMapping("/update")
    public String update(@ModelAttribute("lead") Lead lead) {
        leadDAO.update(lead);
        return "redirect:/leads/"+lead.getId();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        leadDAO.delete(id);
        return "redirect:/leads";
    }
}