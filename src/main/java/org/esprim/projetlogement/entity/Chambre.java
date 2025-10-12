package org.esprim.projetlogement.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;

    private Long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

    // Association ManyToOne avec Bloc
    // La Chambre est le fils (contient la clé étrangère)
    @ManyToOne
    private Bloc bloc;

    // Association ManyToMany avec Reservation
    // La chambre connaît ses réservations
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;
}
