package com.codebase.edic.dto;
import com.codebase.edic.entity.SponsorLevel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SponsorDTO {
    private Long id;
    
    @NotBlank(message = "Name is required")
    private String name;
    
    private String description;
    private String logoUrl;
    private String websiteUrl;
    private SponsorLevel level;
    private Boolean featured;
    private Integer contributionAmount;
    
    @Email(message = "Please provide a valid email")
    private String contactEmail;
    
    private String contactName;
    private String contactPhone;
    private String sponsoredEvent;
}
