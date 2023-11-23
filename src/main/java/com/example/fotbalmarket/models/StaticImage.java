package com.example.fotbalmarket.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "static_images")
public class StaticImage {

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

        @Lob
        private byte[] bytes;

    }
