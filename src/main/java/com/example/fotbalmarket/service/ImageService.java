package com.example.fotbalmarket.service;

import com.example.fotbalmarket.models.Image;
import com.example.fotbalmarket.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    public Image findById(Long id){
        return imageRepository.findById(id).orElse(null);
    }

    public List<Image> getPreviewImages(){
        List<Image> previewImages = new ArrayList<>();
        List<Image> Images = imageRepository.findAll();
        for (Image image:Images ){
            if (image.isPreviewImage()){
                previewImages.add(image);
            }
        }
        return previewImages;
    }
}
