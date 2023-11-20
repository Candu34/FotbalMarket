package com.example.fotbalmarket.service;

import com.example.fotbalmarket.models.Player;
import com.example.fotbalmarket.models.Ratings;
import com.example.fotbalmarket.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;

    public void save(Ratings rating){
        ratingRepository.save(rating);
    }
    public Ratings getRatingByPlayer(Player player){
        return ratingRepository.getRatingsByPlayer(player);
    }
    public void deleteByPlayerID(Long id){
        ratingRepository.deleteByPlayerId(id);
    }
}
