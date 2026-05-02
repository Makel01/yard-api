package edu.famu.cop3060.yard.service;

import edu.famu.cop3060.yard.dto.OpportunityDTO;
import edu.famu.cop3060.yard.store.InMemoryOpportunityStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpportunitiesService {

    private final InMemoryOpportunityStore store;

    // Constructor Injection (REQUIRED)
    public OpportunitiesService(InMemoryOpportunityStore store) {
        this.store = store;
    }

    // Get all (with optional filters later)
    public List<OpportunityDTO> getAll(String type, String q) {
        return store.findAll();
    }

    // Get by ID
    public Optional<OpportunityDTO> getById(String id) {
        return store.findById(id);
    }
}