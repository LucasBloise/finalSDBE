package com.lucasb.finalsd.services;

import com.lucasb.finalsd.entities.dto.RickAndMortyResponseDTO;

public interface RickAndMortyService {
    RickAndMortyResponseDTO getAllCharacters(int page);
} 