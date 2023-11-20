package com.example.fotbalmarket.service;

import com.example.fotbalmarket.models.Image;
import com.example.fotbalmarket.models.TeamImages;
import com.example.fotbalmarket.repository.TeamImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamImagesService {
    private final TeamImageRepository teamImageRepository;

    public TeamImages findById(Long id){
        return teamImageRepository.findById(id).orElse(null);
    }
}
