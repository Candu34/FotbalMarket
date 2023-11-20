package com.example.fotbalmarket.mapper;

import com.example.fotbalmarket.models.Player;
import com.example.fotbalmarket.models.Ratings;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class RatingMapper {

    public Ratings mapToRating(Map<String, String> values, Player player){
        Ratings rating = new Ratings();
        rating.setDefence(Integer.parseInt(values.get("defence")));
        rating.setDribling(Integer.parseInt(values.get("dribbling")));
        rating.setPace(Integer.parseInt(values.get("pace")));
        rating.setPassing(Integer.parseInt(values.get("passing")));
        rating.setPhysic(Integer.parseInt(values.get("physic")));
        rating.setShooting(Integer.parseInt(values.get("shooting")));
        rating.setPlayer(player);
        System.out.println(rating.getPlayer().getName());
        return rating;
    }
}
