package com.example.fotbalmarket.service;

import com.example.fotbalmarket.models.Image;
import com.example.fotbalmarket.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    public Image findById(Long id){
        return imageRepository.findById(id).orElse(null);
    }
}
