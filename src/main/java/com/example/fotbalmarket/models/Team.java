package com.example.fotbalmarket.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "championate")
    private String championate;

    @OneToMany( fetch = FetchType.LAZY,
    mappedBy = "currentTeam")
    private List<Player> players;

    @Column(name = "manager")
    private String manager;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy = "team")
    private List<TeamImages> images = new ArrayList<>();

    private Long previewImageId;



}
