package ua.edu.nupp.controllers;

import ua.edu.nupp.dao.CompanyDAO;
import ua.edu.nupp.models.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String create(@ModelAttribute("company")  Company company) {
        companyDAO.save(company);
        return "redirect:/leads";
    }
      
    @PostMapping("/update")
    public String update(@RequestBody Company company) {
        companyDAO.update(company);
        return "redirect:/leads/"+company.getId();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        companyDAO.delete(id);
        return "redirect:/leads";
    }
}
