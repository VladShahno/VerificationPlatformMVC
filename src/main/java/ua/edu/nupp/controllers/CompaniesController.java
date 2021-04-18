package ua.edu.nupp.controllers;

import ua.edu.nupp.dao.CompanyDAO;
import ua.edu.nupp.models.Company;
import ua.edu.nupp.models.Lead;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/companies")
public class CompaniesController {
    
    private final CompanyDAO companyDAO;

    @Autowired
    public CompaniesController(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }
    
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("companies", companyDAO.index());
        return "companies/index";
    }
    
    @GetMapping("/companies/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("company", companyDAO.show(id));
        return "companies/show";
    }
    
    @GetMapping("/new")
    public String newCompany(@ModelAttribute("company") Company company) {
        return "companies/new";
    }
    
    @PostMapping()
    public String create(@ModelAttribute("company") @Valid Company company,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "companies/new";

        companyDAO.save(company);
        return "redirect:/companies";
    }
      
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("company") @Valid Company company, BindingResult bindingResult,
            @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "leads/show";

        companyDAO.update(id, company);
        return "redirect:/leads/{id}";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        companyDAO.delete(id);
        return "redirect:/leads";
    }
}
