package tn.esprit.desak.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.desak.Entity.Chambre;
import tn.esprit.desak.Entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,String> {
}
