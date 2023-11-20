package com.example.fotbalmarket.repository;

import com.example.fotbalmarket.models.TeamImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamImageRepository extends JpaRepository<TeamImages, Long> {
}
