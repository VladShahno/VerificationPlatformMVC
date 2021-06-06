package ua.edu.nupp.models;

import java.util.Objects;

public class Lead {

    private int id;
    private String firstName;   
    private String lastName;
    private String title;
    private String email;
    private String proof;
    private String verdict;

    public Lead() {
        
    }

    public Lead(int id, String firstName, String lastName, String title, String email, String proof, String verdict) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.email = email;
        this.proof = proof;
        this.verdict = verdict;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }

    public String getVerdict() {
        return verdict;
    }

    public void setVerdict(String verdict) {
        this.verdict = verdict;
    }

    @Override
    public String toString() {
        return "Lead{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", proof='" + proof + '\'' +
                ", verdict='" + verdict + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lead lead = (Lead) o;
        return id == lead.id && Objects.equals(firstName, lead.firstName) && Objects.equals(lastName, lead.lastName) && Objects.equals(title, lead.title) && Objects.equals(email, lead.email) && Objects.equals(proof, lead.proof) && Objects.equals(verdict, lead.verdict);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, title, email, proof, verdict);
    }
}
