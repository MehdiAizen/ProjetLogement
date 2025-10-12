package org.esprim.projetlogement.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    private String idReservation;

    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;

    private boolean estValide;

    // Association ManyToMany avec Chambre (Bidirectionnelle)
    // La réservation connaît les chambres réservées
    @ManyToMany(mappedBy = "reservations", cascade = CascadeType.ALL)
    private Set<Chambre> chambres;

    // Association OneToMany avec Etudiant (Bidirectionnelle)
    // La réservation connaît ses étudiants
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservation")
    private Set<Etudiant> etudiants;
}