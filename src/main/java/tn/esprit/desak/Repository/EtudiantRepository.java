package tn.esprit.desak.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.desak.Entity.Chambre;
import tn.esprit.desak.Entity.Etudiant;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

}
