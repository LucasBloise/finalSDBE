package com.lucasb.finalsd.services;

import com.lucasb.finalsd.model.dto.RickAndMortyResponseDTO;

public interface RickAndMortyService {
    RickAndMortyResponseDTO getAllCharacters(int page);
} 