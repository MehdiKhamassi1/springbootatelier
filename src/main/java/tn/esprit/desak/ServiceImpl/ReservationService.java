package tn.esprit.desak.ServiceImpl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import tn.esprit.desak.Entity.Chambre;
import tn.esprit.desak.Entity.Etudiant;
import tn.esprit.desak.Entity.Reservation;
import tn.esprit.desak.Repository.ChambreRepository;
import tn.esprit.desak.Repository.EtudiantRepository;
import tn.esprit.desak.Repository.ReservationRepository;
import tn.esprit.desak.ServiceInterface.IServiceReservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReservationService implements IServiceReservation {
    ReservationRepository reservationRepository;
    ChambreRepository chambreRepository;
    EtudiantRepository etudiantRepository;
    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return null;
    }
    public Reservation ajouterReservation (long idChambre, long cinEtudiant){
        Chambre chambre = chambreRepository.findById(idChambre).orElse(null);
        Etudiant etudiant = etudiantRepository.findById(cinEtudiant).orElse(null);

        if (chambre!=null || etudiant!=null) {
            Reservation reservation = new Reservation();
            reservation.setAnneeUniversitaire(LocalDate.now());
            reservation.setEstValide(Boolean.TRUE);
            assert chambre != null;
            reservation.setIdReservation(chambre.getNumeroChambre() + "-"
                    + chambre.getBloc().getIdBloc() + "-" + LocalDate.now().getYear());
            reservationRepository.save(reservation);
            chambre.getReservations().add(reservation);
            if (reservation.getEtudiants()==null){
                Set<Etudiant> etudiantSet= new HashSet<>();
                etudiantSet.add(etudiant);
                reservation.setEtudiants(etudiantSet);

            }else {
                reservation.getEtudiants().add(etudiant);
            }

            reservationRepository.save(reservation);
            return reservation;
        }
        return null;

    }
    @Transactional
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant etudiant = etudiantRepository.findById(cinEtudiant).orElse(null);
        List<Chambre> chambres = chambreRepository.findAll();
        assert etudiant != null;
        Set<Reservation> reservations = etudiant.getReservations();
        for (Reservation r : reservations) {
            r.getEtudiants().remove(etudiant);
          //  etudiantRepository.save(etudiant);
            r.setEstValide(false);
            chambres.forEach(chambre -> chambre.getReservations().remove(r));


        }
        return null;
    }
    public List<Reservation> findByAnneeUniversitaireAndNomUniversite(Date anneeUniversite,String nomUniversite)
    {
        return reservationRepository.findByAnneeUniversitaireAndNomUniversite(anneeUniversite,nomUniversite);
    }

}
