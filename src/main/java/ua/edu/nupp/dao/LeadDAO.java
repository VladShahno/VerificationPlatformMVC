package ua.edu.nupp.dao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import ua.edu.nupp.models.*;

@Component
public class LeadDAO {
    private List<Lead> leads;

    {
        leads = new ArrayList<>();
        leads.add(new Lead(1,"John", "Snow","CTO", "John.Snow@microsoft.com","N/A"));
        leads.add(new Lead(2,"Joh", "Snow","CTO", "John.Snow@microsoft.com","N/A"));
        leads.add(new Lead(3,"Jo", "Snow","CTO", "John.Snow@microsoft.com","N/A"));
        leads.add(new Lead(4,"Jo", "Snow","CTO", "John.Snow@microsoft.com","N/A"));
    }
    
    public List<Lead> index() {
        return leads;
    }
    
    public Lead show(int id) {
        return leads.stream().filter(leads->leads.getId() == id).findAny().orElse(null);
    }
}
