package com.lucasb.finalsd.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDTO {
    private String name;
    private String url;
} 