package com.example.fotbalmarket.service;


import com.example.fotbalmarket.models.Player;
import com.example.fotbalmarket.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerService {

    private final PlayerRepository playerRepository;

    public void save(Player player){
        playerRepository.save(player);
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
}
