package com.codebase.edic.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codebase.edic.dto.SponsorDTO;
import com.codebase.edic.entity.SponsorLevel;
import com.codebase.edic.service.SponsorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sponsors")
public class SponsorController {
    private final SponsorService sponsorService;


    public SponsorController(SponsorService sponsorService) {
        this.sponsorService = sponsorService;
    }

    @GetMapping
    public ResponseEntity<List<SponsorDTO>> getAllSponsors() {
        return ResponseEntity.ok(sponsorService.getAllSponsors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SponsorDTO> getSponsorById(@PathVariable Long id) {
        return ResponseEntity.ok(sponsorService.getSponsorById(id));
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<List<SponsorDTO>> getSponsorsByLevel(@PathVariable SponsorLevel level) {
        return ResponseEntity.ok(sponsorService.getSponsorsByLevel(level));
    }

    @GetMapping("/featured")
    public ResponseEntity<List<SponsorDTO>> getFeaturedSponsors() {
        return ResponseEntity.ok(sponsorService.getFeaturedSponsors());
    }

    @GetMapping("/search")
    public ResponseEntity<List<SponsorDTO>> searchSponsors(@RequestParam String name) {
        return ResponseEntity.ok(sponsorService.searchSponsors(name));
    }
    
    @GetMapping("/event")
    public ResponseEntity<List<SponsorDTO>> getSponsorsByEvent(@RequestParam String event) {
        return ResponseEntity.ok(sponsorService.getSponsorsByEvent(event));
    }

    @PostMapping
    public ResponseEntity<SponsorDTO> createSponsor(@Valid @RequestBody SponsorDTO sponsorDTO) {
        return new ResponseEntity<>(sponsorService.createSponsor(sponsorDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SponsorDTO> updateSponsor(@PathVariable Long id, @Valid @RequestBody SponsorDTO sponsorDTO) {
        return ResponseEntity.ok(sponsorService.updateSponsor(id, sponsorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSponsor(@PathVariable Long id) {
        sponsorService.deleteSponsor(id);
        return ResponseEntity.noContent().build();
    }
}
