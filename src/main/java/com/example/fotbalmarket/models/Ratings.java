package com.example.fotbalmarket.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ratings")
public class Ratings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;

    @Column(name = "pace")
    private int pace;
    @Column(name = "shooting")
    private int shooting;
    @Column(name = "passing")
    private int passing;
    @Column(name = "dribling")
    private int dribling;
    @Column(name = "defence")
    private int defence;
    @Column(name = "physic")
    private int physic;

    @Column(name = "overall")
    private float overall;

}
