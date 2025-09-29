package org.esprim.projetlogement.service;

import org.esprim.projetlogement.entity.Reservation;
import org.esprim.projetlogement.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Reservation add(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation update(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void delete(String id) {
        reservationRepository.deleteById(id);
    }
}