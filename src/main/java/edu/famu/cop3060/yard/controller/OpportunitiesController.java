package edu.famu.cop3060.yard.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.famu.cop3060.yard.dto.OpportunityDTO;
import edu.famu.cop3060.yard.service.OpportunitiesService;

@RestController
@RequestMapping("/api/opportunities")
public class OpportunitiesController {

    private final OpportunitiesService service;

    // Constructor Injection (REQUIRED)
    public OpportunitiesController(OpportunitiesService service) {
        this.service = service;
    }

    // GET all opportunities
    @GetMapping
    public List<OpportunityDTO> getAll(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String q) {

        return service.getAll(type, q);
    }

    // GET one opportunity by ID
    @GetMapping("/{id}")
    public OpportunityDTO getById(@PathVariable String id) {
        return service.getById(id).orElse(null);
    }
}