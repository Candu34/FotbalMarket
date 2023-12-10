package com.example.fotbalmarket.repository;

import com.example.fotbalmarket.models.Player;
import com.example.fotbalmarket.models.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Ratings, Long> {

    public Ratings getRatingsByPlayer(Player player);
    public void deleteByPlayerId(Long id);
    public List<Ratings> findAllByOverall(float overall);
}
