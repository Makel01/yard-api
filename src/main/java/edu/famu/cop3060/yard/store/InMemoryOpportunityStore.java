package edu.famu.cop3060.yard.store;

import edu.famu.cop3060.yard.dto.OpportunityDTO;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InMemoryOpportunityStore {

    private final List<OpportunityDTO> list = new ArrayList<>();
    private final Map<String, OpportunityDTO> map = new HashMap<>();

    public InMemoryOpportunityStore() {

        add(new OpportunityDTO("opp-001","UNCF STEM Scholarship","Scholarship",
                "UNCF","2025-04-15","STEM scholarship",
                List.of("STEM","paid"),"https://uncf.org"));

        add(new OpportunityDTO("opp-002","Google Residency","Fellowship",
                "Google","2025-06-01","Tech program",
                List.of("tech","paid"),"https://google.com"));

        add(new OpportunityDTO("opp-003","NSBE","Organization",
                "NSBE","N/A","Engineering org",
                List.of("engineering"),"https://nsbe.org"));

        add(new OpportunityDTO("opp-004","Step Show","Event",
                "Campus","2025-10-01","Homecoming event",
                List.of("culture"),"https://school.edu"));
    }

    private void add(OpportunityDTO o) {
        list.add(o);
        map.put(o.getId(), o);
    }

    public List<OpportunityDTO> findAll() {
        return list;
    }

    public Optional<OpportunityDTO> findById(String id) {
        return Optional.ofNullable(map.get(id));
    }
}