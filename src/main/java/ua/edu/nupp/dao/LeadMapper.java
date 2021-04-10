package ua.edu.nupp.dao;

import ua.edu.nupp.models.Lead;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class LeadMapper implements RowMapper<Lead>{

    @Override
    public Lead mapRow(ResultSet resultSet, int i) throws SQLException {

        Lead lead = new Lead();

        lead.setId(resultSet.getInt("id"));
        lead.setFirstName(resultSet.getString("firstname"));
        lead.setLastName(resultSet.getString("lastname"));
        lead.setTitle(resultSet.getString("title"));
        lead.setEmail(resultSet.getString("email"));
        lead.setProof(resultSet.getString("proof"));

        return lead;
    }

}
