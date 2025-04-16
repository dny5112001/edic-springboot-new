package com.codebase.edic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sponsors")
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Name is required")
    private String name;
    
    @Column(length = 1000)
    private String description;
    
    private String logoUrl;
    
    private String websiteUrl;
    
    @Enumerated(EnumType.STRING)
    private SponsorLevel level;
    
    private Boolean featured = false;
    
    private Integer contributionAmount;
    
    private String contactEmail;
    
    private String contactName;
    
    private String contactPhone;
    
    private String sponsoredEvent;
}

