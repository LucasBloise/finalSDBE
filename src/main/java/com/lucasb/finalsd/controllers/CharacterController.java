package com.lucasb.finalsd.controllers;

import com.lucasb.finalsd.model.dto.RickAndMortyResponseDTO;
import com.lucasb.finalsd.services.RickAndMortyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final RickAndMortyService rickAndMortyService;

    public CharacterController(RickAndMortyService rickAndMortyService) {
        this.rickAndMortyService = rickAndMortyService;
    }

    @GetMapping
    public RickAndMortyResponseDTO getAllCharacters(@RequestParam(defaultValue = "1") int page) {
        return rickAndMortyService.getAllCharacters(page);
    }
} 