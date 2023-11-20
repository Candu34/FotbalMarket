package com.example.fotbalmarket.controller;

import com.example.fotbalmarket.mapper.RatingMapper;
import com.example.fotbalmarket.models.Player;
import com.example.fotbalmarket.models.Ratings;
import com.example.fotbalmarket.service.PlayerService;
import com.example.fotbalmarket.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@Controller
public class RatingController {

    private final RatingService ratingService;
    private final PlayerService playerService;
    private final RatingMapper ratingMapper;

//    @PostMapping(value = "rating/create")
//    public String createRating(@RequestBody Map<String, String> jsonBody) {
//        Player player = playerService.findById(Long.parseLong(jsonBody.get("playerId")));
//        Ratings rating = ratingMapper.mapToRating(jsonBody, player);
//        ratingService.save(rating);
//        return "redirect:/players/{playerID}";
//    }

    @PostMapping(value = "rating/create")
    public String createRating( @RequestParam Map<String, String> formParams) {
        Long playerId = Long.parseLong(formParams.get("playerId"));
        Player player = playerService.findById(playerId);
        Ratings rating = ratingMapper.mapToRating(formParams, player);
        ratingService.save(rating);
        return "redirect:/players";
    }
}
