package com.lucasb.finalsd.services.impl;

import com.lucasb.finalsd.model.dto.RickAndMortyResponseDTO;
import com.lucasb.finalsd.services.RickAndMortyService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RickAndMortyServiceImpl implements RickAndMortyService {

    private final RestTemplate restTemplate;

    public RickAndMortyServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public RickAndMortyResponseDTO getAllCharacters(int page) {
        String url = "https://rickandmortyapi.com/api/character?page=" + page;
        return restTemplate.getForObject(url, RickAndMortyResponseDTO.class);
    }
} 