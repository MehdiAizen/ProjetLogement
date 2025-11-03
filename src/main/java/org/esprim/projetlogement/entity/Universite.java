package org.esprim.projetlogement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;

    private String nomUniversite;
    private String adresse;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foyer_id")
    private Foyer foyer;
}