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

        int defence = Integer.parseInt(values.get("defence"));
        int dribbling = Integer.parseInt(values.get("dribbling"));
        int pace = Integer.parseInt(values.get("pace"));
        int passing = Integer.parseInt(values.get("passing"));
        int physic = Integer.parseInt(values.get("physic"));
        int shooting = Integer.parseInt(values.get("shooting"));
        rating.setDefence(defence);
        rating.setDribling(dribbling);
        rating.setPace(pace);
        rating.setPassing(passing);
        rating.setPhysic(physic);
        rating.setShooting(shooting);
        float overall = (float) (defence + dribbling + pace + passing + physic + shooting) / 6;
        rating.setOverall(overall);
        rating.setPlayer(player);
        System.out.println(rating.getPlayer().getName());
        return rating;
    }
}
