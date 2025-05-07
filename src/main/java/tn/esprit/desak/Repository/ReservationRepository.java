package tn.esprit.desak.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.desak.Entity.Chambre;
import tn.esprit.desak.Entity.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,String> {
    @Query("SELECT r FROM Chambre c JOIN c.reservations r " + "WHERE r.anneeUniversitaire = :anneeUniversite " + "AND c.bloc.foyer.universite.nomUniversite = :nomUniversite")
    List<Reservation> findByAnneeUniversitaireAndNomUniversite(@Param("anneeUniversite") Date anneeUniversite,@Param("nomUniversite") String nomUniversite);
}
