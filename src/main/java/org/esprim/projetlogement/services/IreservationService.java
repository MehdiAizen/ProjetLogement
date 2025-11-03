package org.esprim.projetlogement.services;

import org.esprim.projetlogement.entity.Reservation;
import java.util.List;

public interface IReservationService {
    List<Reservation> getAllReservations();
    Reservation getReservationById(String id);
    Reservation saveReservation(Reservation reservation);
    void deleteReservationById(String id);
    Reservation updateReservation(Reservation reservation);
}