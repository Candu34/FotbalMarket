package com.example.fotbalmarket.repository;


import com.example.fotbalmarket.models.Image;
import com.example.fotbalmarket.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    public Image getImagesByPlayer(Player player);
}
