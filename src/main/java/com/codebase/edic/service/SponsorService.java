package com.codebase.edic.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.codebase.edic.dto.SponsorDTO;
import com.codebase.edic.entity.Sponsor;
import com.codebase.edic.entity.SponsorLevel;
import com.codebase.edic.repository.SponsorRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class SponsorService {
    private final SponsorRepository sponsorRepository;

    public SponsorService(SponsorRepository sponsorRepository) {
        this.sponsorRepository = sponsorRepository;
    }

    public List<SponsorDTO> getAllSponsors() {
        return sponsorRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public SponsorDTO getSponsorById(Long id) {
        Sponsor sponsor = sponsorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sponsor not found with id: " + id));
        return convertToDTO(sponsor);
    }

    public List<SponsorDTO> getSponsorsByLevel(SponsorLevel level) {
        return sponsorRepository.findByLevel(level).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<SponsorDTO> getFeaturedSponsors() {
        return sponsorRepository.findByFeaturedTrue().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<SponsorDTO> searchSponsors(String name) {
        return sponsorRepository.findByNameContainingIgnoreCase(name).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<SponsorDTO> getSponsorsByEvent(String event) {
        return sponsorRepository.findBySponsoredEventContainingIgnoreCase(event).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public SponsorDTO createSponsor(SponsorDTO sponsorDTO) {
        Sponsor sponsor = convertToEntity(sponsorDTO);
        Sponsor savedSponsor = sponsorRepository.save(sponsor);
        return convertToDTO(savedSponsor);
    }

    @Transactional
    public SponsorDTO updateSponsor(Long id, SponsorDTO sponsorDTO) {
        if (!sponsorRepository.existsById(id)) {
            throw new EntityNotFoundException("Sponsor not found with id: " + id);
        }
        
        Sponsor sponsor = convertToEntity(sponsorDTO);
        sponsor.setId(id);
        Sponsor updatedSponsor = sponsorRepository.save(sponsor);
        return convertToDTO(updatedSponsor);
    }

    @Transactional
    public void deleteSponsor(Long id) {
        if (!sponsorRepository.existsById(id)) {
            throw new EntityNotFoundException("Sponsor not found with id: " + id);
        }
        sponsorRepository.deleteById(id);
    }

    private SponsorDTO convertToDTO(Sponsor sponsor) {
        SponsorDTO sponsorDTO = new SponsorDTO();
        BeanUtils.copyProperties(sponsor, sponsorDTO);
        return sponsorDTO;
    }

    private Sponsor convertToEntity(SponsorDTO sponsorDTO) {
        Sponsor sponsor = new Sponsor();
        BeanUtils.copyProperties(sponsorDTO, sponsor);
        return sponsor;
    }
}
