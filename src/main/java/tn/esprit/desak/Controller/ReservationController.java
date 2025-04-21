package tn.esprit.desak.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.desak.Entity.Reservation;
import tn.esprit.desak.ServiceInterface.IServiceReservation;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReservationController {
    IServiceReservation serviceReservation;
    @GetMapping("/getReservations")
    public List<Reservation> retrieveAllReservation() {
        return serviceReservation.retrieveAllReservation();
    }
    @PutMapping("/ReservationUpdate")
    public Reservation updateReservation(@RequestBody Reservation res) {
        return serviceReservation.updateReservation(res);
    }
    @GetMapping("/reservationID/{idReservation}")
    public Reservation retrieveReservation(@PathVariable String idReservation) {
        return serviceReservation.retrieveReservation(idReservation);
    }
    @PostMapping("/ajouter/{idChambre}/{cinEtudiant}")
    public Reservation ajouterreservation(@PathVariable long idChambre, @PathVariable long cinEtudiant) {
        return serviceReservation.ajouterReservation(idChambre,cinEtudiant);
    }

    @PostMapping("/annuler/{cinEtudiant}")
    public Reservation annulerRes(@PathVariable long cinEtudiant) {
        return serviceReservation.annulerReservation(cinEtudiant);
    }
}
