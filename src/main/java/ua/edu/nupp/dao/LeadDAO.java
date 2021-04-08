package ua.edu.nupp.dao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import ua.edu.nupp.models.*;

@Component
public class LeadDAO {
    private static int LEADS_COUNT;
    private List<Lead> leads;

    {
        leads = new ArrayList<>();
        leads.add(new Lead(++LEADS_COUNT,"John", "Snow","CTO", "John.Snow@microsoft.com","N/A"));
        leads.add(new Lead(++LEADS_COUNT,"Joh", "Snow","CTO", "John.Snow@microsoft.com","N/A"));
        leads.add(new Lead(++LEADS_COUNT,"Jo", "Snow","CTO", "John.Snow@microsoft.com","N/A"));
        leads.add(new Lead(++LEADS_COUNT,"Jo", "Snow","CTO", "John.Snow@microsoft.com","N/A"));
    }
    
    public List<Lead> index() {
        return leads;
    }
    
    public Lead show(int id) {
        return leads.stream().filter(lead -> lead.getId() == id).findAny().orElse(null);
    }
    
    public void save(Lead lead) {
        lead.setId(++ LEADS_COUNT);
        leads.add(lead);
    }
    
    public void update(int id, Lead updetatedLead) {
        Lead leadToBeUpdated = show(id);
        leadToBeUpdated.setFirstName(updetatedLead.getFirstName());
    }
    
    
   
}
