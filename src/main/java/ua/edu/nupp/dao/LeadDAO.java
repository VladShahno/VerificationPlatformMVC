package ua.edu.nupp.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import ua.edu.nupp.models.*;
import java.sql.*;

@Component
public class LeadDAO {
    private static int LEADS_COUNT;

    private static final String URL = "jdbc:postgresql://localhost:5432/DiplomaDataBase";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1234";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } 
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public List<Lead> index() {
        List<Lead> leads = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM lead";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()) {
                Lead lead = new Lead();

                lead.setId(resultSet.getInt("id"));
                lead.setFirstName(resultSet.getString("firstname"));
                lead.setLastName(resultSet.getString("lastname"));
                lead.setTitle(resultSet.getString("title"));
                lead.setEmail(resultSet.getString("email"));
                lead.setProof(resultSet.getString("proof"));
                leads.add(lead);
            }

        } 
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return leads;
    }

    public Lead show(int id) {
        Lead lead = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM lead WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            lead = new Lead();

            lead.setId(resultSet.getInt("id"));
            lead.setFirstName(resultSet.getString("firstname"));
            lead.setLastName(resultSet.getString("lastname"));
            lead.setTitle(resultSet.getString("title"));
            lead.setEmail(resultSet.getString("email"));
            lead.setProof(resultSet.getString("proof"));
        } 
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return lead;
    }

    public void save(Lead lead) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO lead VALUES(1, ?, ?, ?,?,?)");

            preparedStatement.setString(1, lead.getFirstName());
            preparedStatement.setString(2, lead.getLastName());
            preparedStatement.setString(3, lead.getTitle());
            preparedStatement.setString(4, lead.getEmail());
            preparedStatement.setString(5, lead.getProof());

            preparedStatement.executeUpdate();
        } 
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Lead updatedLead) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE lead SET firstname=?, lastname=?, "
                            + "title=?, email=?, proof=? WHERE id=?");

            preparedStatement.setString(1, updatedLead.getFirstName());
            preparedStatement.setString(2, updatedLead.getLastName());
            preparedStatement.setString(3, updatedLead.getTitle());
            preparedStatement.setString(4, updatedLead.getEmail());
            preparedStatement.setString(5, updatedLead.getProof());
            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();
        } 
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM lead WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } 
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
