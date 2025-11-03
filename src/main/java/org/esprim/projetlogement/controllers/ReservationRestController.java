package org.esprim.projetlogement.controllers;

import org.esprim.projetlogement.entity.Reservation;
import org.esprim.projetlogement.services.IReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@Tag(name = "Gestion des Réservations", description = "API CRUD pour la gestion des réservations")
public class ReservationRestController {

    @Autowired
    private IReservationService reservationService;

    @Operation(summary = "Récupérer toutes les réservations")
    @GetMapping
    public List<Reservation> retrieveAllReservations() {
        return reservationService.getAllReservations();
    }

    @Operation(summary = "Récupérer une réservation par ID")
    @GetMapping("/{reservationId}")
    public Reservation retrieveReservationById(@PathVariable String reservationId) {
        return reservationService.getReservationById(reservationId);
    }

    @Operation(summary = "Ajouter une nouvelle réservation")
    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }

    @Operation(summary = "Supprimer une réservation")
    @DeleteMapping("/{reservationId}")
    public void removeReservation(@PathVariable String reservationId) {
        reservationService.deleteReservationById(reservationId);
    }

    @Operation(summary = "Modifier une réservation")
    @PutMapping
    public Reservation modifyReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }
}