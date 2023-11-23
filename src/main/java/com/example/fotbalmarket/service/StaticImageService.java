package com.example.fotbalmarket.service;


import com.example.fotbalmarket.models.Image;
import com.example.fotbalmarket.models.StaticImage;
import com.example.fotbalmarket.repository.StaticImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class StaticImageService {

    private final StaticImageRepository staticImageRepository;

    public StaticImage findById(Long id) {
        return staticImageRepository.findById(id).orElse(null);
    }

    public StaticImage findByName(String name) {
        return staticImageRepository.findByName(name);
    }

    public void save(MultipartFile file) throws IOException {
        staticImageRepository.save(toImageEntity(file));
    }

    private StaticImage toImageEntity(MultipartFile file) throws IOException {
        StaticImage image = new StaticImage();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
}
