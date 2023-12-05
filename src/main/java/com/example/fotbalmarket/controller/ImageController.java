package com.example.fotbalmarket.controller;

import com.example.fotbalmarket.models.Image;
import com.example.fotbalmarket.models.TeamImages;
import com.example.fotbalmarket.service.ImageService;
import com.example.fotbalmarket.service.TeamImagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;
    private final TeamImagesService teamImagesService;


    @GetMapping("/images/{id}")
    private ResponseEntity<?> getImagebyId(@PathVariable Long id){
        Image image = imageService.findById(id);
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));

    }

    @GetMapping("/images/team/{id}")
    private ResponseEntity<?> getTeamImagebyId(@PathVariable Long id){
        TeamImages image = teamImagesService.findById(id);
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));

    }




}