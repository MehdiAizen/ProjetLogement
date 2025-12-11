package org.esprim.projetlogement.repository;

import org.esprim.projetlogement.entity.Chambre;
import org.esprim.projetlogement.entity.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    // JPQL: Get chambres by university name
    @Query("SELECT c FROM Chambre c " +
            "JOIN c.bloc b " +
            "JOIN b.foyer f " +
            "JOIN f.universite u " +
            "WHERE u.nomUniversite = :nomUniversite")
    List<Chambre> findChambresParNomUniversite(@Param("nomUniversite") String nomUniversite);

    // JPQL: Get chambres by bloc and type
    @Query("SELECT c FROM Chambre c " +
            "WHERE c.bloc.idBloc = :idBloc AND c.typeChambre = :type")
    List<Chambre> findChambresParBlocEtTypeJPQL(
            @Param("idBloc") Long idBloc,
            @Param("type") TypeChambre type);

    // Keywords: Alternative solution for getting chambres by bloc and type
    List<Chambre> findByBlocIdBlocAndTypeChambre(Long idBloc, TypeChambre typeChambre);

    // JPQL: Get non-reserved chambres by university and type
    @Query("SELECT c FROM Chambre c " +
            "WHERE c.bloc.foyer.universite.nomUniversite = :nomUniversite " +
            "AND c.typeChambre = :type " +
            "AND (c.reservations IS EMPTY)")
    List<Chambre> findChambresNonReserveesParNomUnivEtType(
            @Param("nomUniversite") String nomUniversite,
            @Param("type") TypeChambre type);

    // JPQL: Get all non-reserved chambres for scheduler
    @Query("SELECT c FROM Chambre c " +
            "WHERE c.reservations IS EMPTY")
    List<Chambre> findChambresNonReservees();
}