package com.example.fotbalmarket.repository;

import com.example.fotbalmarket.models.StaticImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaticImageRepository extends JpaRepository<StaticImage, Long> {

    public StaticImage findByName(String name);
}
