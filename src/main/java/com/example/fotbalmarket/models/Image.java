package com.example.fotbalmarket.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;

@Entity
@Table(name = "images")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Image {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "originalFileName", nullable = false)
    private String originalFileName;

    @Column(name = "size", nullable = false)
    private Long size;

    @Column(name = "contentType", nullable = false)
    private String contentType;

    @Column(name = "dateOfCreated")
    private LocalDateTime dateOfCreated;

    @Column(name = "isPreviewImage", nullable = false)
    private boolean isPreviewImage;

    @Lob
    private byte[] bytes;


    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Player player;

    @PrePersist
    private void init(){
        dateOfCreated = LocalDateTime.now();
    }


}
