package tn.esprit.desak.ServiceInterface;

import tn.esprit.desak.Entity.Chambre;
import tn.esprit.desak.Entity.Reservation;

import java.util.List;

public interface IServiceReservation {
    List<Reservation> retrieveAllReservation();
    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (String idReservation);
    public Reservation ajouterReservation (long idChambre, long cinEtudiant);
    public Reservation annulerReservation(long cinEtudiant);
}
