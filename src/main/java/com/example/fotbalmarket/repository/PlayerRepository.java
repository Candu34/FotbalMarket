package com.example.fotbalmarket.repository;

import com.example.fotbalmarket.models.Player;
import com.example.fotbalmarket.models.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    public List<Player> getPlayersByCountry(String country);

    public List<Player> getPlayersByCurrentTeam(Team currentTeam);

    public Player getPlayersByName(String name);

    public List<Player> findAllByName(String name);

    public List<Player> findPlayersByRatingOverallGreaterThan(float overall);

}
