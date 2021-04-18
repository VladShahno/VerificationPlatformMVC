package ua.edu.nupp.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.edu.nupp.models.Lead;

@Component
public class LeadDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LeadDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Lead> index() {
        return jdbcTemplate.query("SELECT * FROM lead", new BeanPropertyRowMapper<>(Lead.class));
    }

    @SuppressWarnings("deprecation")
    public Lead show(int id) {
        return jdbcTemplate.query("SELECT * FROM lead WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Lead.class))
                .stream().findAny().orElse(null);
    }

    public void save(Lead lead) {
        jdbcTemplate.update("INSERT INTO lead VALUES(?, ?, ?, ?, ?, ?)", lead.getId(), lead.getFirstName(), lead.getLastName(), 
                lead.getTitle(), lead.getEmail(), lead.getProof());
    }

    public void update(int id, Lead updatedLead){
        jdbcTemplate.update("UPDATE lead SET firstname=?, lastname=?, title=?, email=?, proof=? WHERE id=?", 
                updatedLead.getFirstName(), updatedLead.getLastName(), updatedLead.getTitle(), 
                updatedLead.getEmail(), updatedLead.getProof(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM lead WHERE id=?", id);
    }
}
