package org.esprim.projetlogement.repository;

import org.esprim.projetlogement.entity.Logement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogementRepository extends JpaRepository<Logement, Integer> {
}