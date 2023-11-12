package com.example.fotbalmarket.service;


import com.example.fotbalmarket.models.Team;
import com.example.fotbalmarket.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
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

    public void save(Team team){
        teamRepository.save(team);
    }

    public void deleteById(long id){
        teamRepository.deleteById(id);
    }
}
