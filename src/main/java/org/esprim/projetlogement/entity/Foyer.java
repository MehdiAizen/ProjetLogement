package org.esprim.projetlogement.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;

    private String nomFoyer;
    private Long capaciteFoyer;

    // Association ManyToOne avec Universite
    // LE FOYER EST LE FILS (contient la clé étrangère)
    @ManyToOne
    private Universite universite;

    // Association OneToMany avec Bloc (Bidirectionnelle)
    // Le foyer connaît ses blocs
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foyer")
    private Set<Bloc> blocs;
}