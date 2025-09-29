package org.esprim.projetlogement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Logement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reference;

    private String adresse;
    private String delegation;
    private String gouvernorat;
    private String type;
    private String description;
    private float prix;
}
