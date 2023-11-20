package com.example.fotbalmarket.service;


import com.example.fotbalmarket.models.Image;
import com.example.fotbalmarket.models.Player;
import com.example.fotbalmarket.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerService {

    private final PlayerRepository playerRepository;

    public void saveProduct( Player player, List<MultipartFile> files) throws IOException {

        List<Image> images = new ArrayList<>();

        for (MultipartFile file : files) {
            if (file.getSize() != 0) {
                Image image = toImageEntity(file);
                image.setPlayer(player);
                images.add(image);
            }
        }
        if(!images.isEmpty()) {
            images.get(0).setPreviewImage(true);
        }
        player.setImages(images);


        log.info("Saving new Product. Title: {}; ",
                player.getName());

        Player playerFromDb = playerRepository.save(player);
        playerFromDb.setPreviewImageId(playerFromDb.getImages().get(0).getId());
        playerRepository.save(player);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }


    public List<Player> findAll(){
        return playerRepository.findAll();
    }

    public Player findById(long id){
        return playerRepository.findById(id).orElse(null);
    }

    public void deleteById(long id){
        playerRepository.deleteById(id);
    }

    public List<Player> getPlayersByCountry(String country){
        return playerRepository.getPlayersByCountry(country);
    }
}
