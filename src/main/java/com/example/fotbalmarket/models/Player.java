package com.example.fotbalmarket.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "players")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "country", nullable = false)
    private String country;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private Team currentTeam;

    @Column(name = "price")
    private int price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy = "player")
    private List<Image> images = new ArrayList<>();

    @OneToOne(mappedBy = "player")
    private Ratings rating;

    private Long previewImageId;



}
