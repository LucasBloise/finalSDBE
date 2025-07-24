package com.lucasb.finalsd.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoDTO {
    private int count;
    private int pages;
    private String next;
    private String prev;
} 