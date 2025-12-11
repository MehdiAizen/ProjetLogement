package org.esprim.projetlogement.repository;

import org.esprim.projetlogement.entity.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {
    // In BlocRepository
    @Query("SELECT b FROM Bloc b LEFT JOIN FETCH b.chambres")
    List<Bloc> findAllWithChambres();
}