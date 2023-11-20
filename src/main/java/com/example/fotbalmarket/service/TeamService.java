package com.example.fotbalmarket.service;


import com.example.fotbalmarket.models.Image;
import com.example.fotbalmarket.models.Player;
import com.example.fotbalmarket.models.Team;
import com.example.fotbalmarket.models.TeamImages;
import com.example.fotbalmarket.repository.TeamRepository;
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
public class TeamService {

    private final TeamRepository teamRepository;

    public List<Team> findAll(String name){

        if(name != null)
            return teamRepository.findByName(name);
        return teamRepository.findAll();
    }

    public Team findById(long id){
        return teamRepository.findById(id).orElse(null);
    }

    public void saveTeam(Team team, List<MultipartFile> files) throws IOException {

        List<TeamImages> images = new ArrayList<>();

        for (MultipartFile file : files) {
            if (file.getSize() != 0) {
                TeamImages image = toImageEntity(file);
                image.setTeam(team);
                images.add(image);
            }
        }
        if(!images.isEmpty()) {
            images.get(0).setPreviewImage(true);
        }
        team.setImages(images);


        log.info("Saving new Team. Title: {}; ",
                team.getName());

        Team teamFromDB = teamRepository.save(team);
        teamFromDB.setPreviewImageId(teamFromDB.getImages().get(0).getId());
        teamRepository.save(team);
    }

    private TeamImages toImageEntity(MultipartFile file) throws IOException {
        TeamImages image = new TeamImages();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
    public void deleteById(long id){
        teamRepository.deleteById(id);
    }
}
