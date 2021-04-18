package ua.edu.nupp.dao;

import ua.edu.nupp.models.Company;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CompanyDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CompanyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Company> index() {
        return jdbcTemplate.query("SELECT * FROM company", new BeanPropertyRowMapper<>(Company.class));
    }

    @SuppressWarnings("deprecation")
    public Company show(int id) {
        return jdbcTemplate.query("SELECT * FROM company WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Company.class))
                .stream().findAny().orElse(null);
    }

    public void save(Company company) {
        jdbcTemplate.update("INSERT INTO company VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", company.getId(), 
                company.getName(), company.getSizeproof(), 
                company.getSize(), company.getRevenueproof(), company.getRevenue(), company.getIndustry(),
                company.getPhone(), company.getCountry(), company.getState(), company.getStreet(), 
                company.getCity(), company.getZip());
    }

    public void update(int id, Company updatedcompany){
        jdbcTemplate.update("UPDATE company SET name=? WHERE id=?", 
                updatedcompany.getName(), id);
    }
    
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM company WHERE id=?", id);
    }
}
