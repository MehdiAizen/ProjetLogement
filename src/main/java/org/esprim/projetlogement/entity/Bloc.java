package org.esprim.projetlogement.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;

    private String nomBloc;
    private Long capaciteBloc;

    // Association ManyToOne avec Foyer
    // Le Bloc est le fils (contient la clé étrangère)
    @ManyToOne
    private Foyer foyer;

    // Association OneToMany avec Chambre (Bidirectionnelle)
    // Le bloc connaît ses chambres
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloc")
    private Set<Chambre> chambres;
}