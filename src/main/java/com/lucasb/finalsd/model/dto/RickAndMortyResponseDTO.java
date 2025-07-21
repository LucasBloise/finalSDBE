package com.lucasb.finalsd.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RickAndMortyResponseDTO {
    private InfoDTO info;
    private List<CharacterDTO> results;
} 