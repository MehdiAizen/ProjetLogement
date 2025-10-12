package org.esprim.projetlogement.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;

    private String nomUniversite;
    private String adresse;

    // Association OneToMany avec Foyer (Bidirectionnelle)
    // L'université connaît ses foyers
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universite")
    private Set<Foyer> foyers;
}
