package com.example.fotbalmarket.repository;

import com.example.fotbalmarket.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    public List<Player> getPlayersByCountry(String country);
}
