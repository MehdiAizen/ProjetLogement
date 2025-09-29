package org.esprim.projetlogement.repository;

import org.esprim.projetlogement.entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}