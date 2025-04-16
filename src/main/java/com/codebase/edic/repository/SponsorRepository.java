package com.codebase.edic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codebase.edic.entity.Sponsor;
import com.codebase.edic.entity.SponsorLevel;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor, Long> {
    List<Sponsor> findByLevel(SponsorLevel level);
    List<Sponsor> findByFeaturedTrue();
    List<Sponsor> findByNameContainingIgnoreCase(String name);
    List<Sponsor> findBySponsoredEventContainingIgnoreCase(String event);
}
